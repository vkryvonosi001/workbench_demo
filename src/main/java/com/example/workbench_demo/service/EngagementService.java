package com.example.workbench_demo.service;

import com.example.workbench_demo.model.Engagement;
import com.example.workbench_demo.model.Role;
import com.example.workbench_demo.model.TeamMember;
import com.example.workbench_demo.model.User;
import com.example.workbench_demo.repository.EngagementRepository;
import com.example.workbench_demo.repository.RoleRepository;
import com.example.workbench_demo.repository.TeamMemberRepository;
import com.example.workbench_demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static org.springframework.util.ReflectionUtils.findField;
import static org.springframework.util.ReflectionUtils.setField;

@Service
@Transactional
public class EngagementService {
    private final EngagementRepository engagementRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final TeamMemberRepository teamMemberRepository;

    public EngagementService(EngagementRepository engagementRepository,
                             RoleRepository roleRepository, UserRepository userRepository,
                             TeamMemberRepository teamMemberRepository) {
        this.engagementRepository = engagementRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.teamMemberRepository = teamMemberRepository;
    }

    public List<User> getUsersForEngagementByEmail(List<String> emails, String engagementId) {
        Engagement engagement = getEngagementById(engagementId);
        return engagement.getTeamMembers().stream()
                .filter(teamMember -> emails.contains(teamMember.getEmail()))
                .map(TeamMember::getUser)
                .collect(Collectors.toList());
    }

    public void deleteTeamMember(TeamMember teamMember, String engagementId) {
        Engagement engagement = getEngagementById(engagementId);

        if (!engagement.getTeamMembers().contains(teamMember)) {
            throw new IllegalArgumentException("Given team member isn't part of the provided engagement");
        }

        engagement.getTeamMembers().remove(teamMember);
        engagementRepository.save(engagement);
    }

    public TeamMember addTeamMember(TeamMember teamMember, String engagementId) {
        User user = getUserByEmail(teamMember.getEmail());
        Engagement engagement = getEngagementById(engagementId);

        if (engagement.getTeamMembers().contains(teamMember)) {
            throw new IllegalArgumentException("Given team member is already part of the provided engagement");
        }

        validateTeamMember(teamMember, user);

        teamMember.setEngagement(engagement);
        teamMember.setUser(user);
        teamMemberRepository.save(teamMember);

        teamMember.getRoles().forEach(role -> {
            role.setMember(teamMember);
            roleRepository.save(role);
        });
        return teamMember;
    }

    public TeamMember editTeamMember(Map<String, Object> fields, String engagementId, String email) {
        Engagement engagement = getEngagementById(engagementId);

        TeamMember toEdit = engagement.getTeamMembers().stream()
                .filter(teamMember -> teamMember.getEmail().equals(email))
                .findFirst().orElseThrow(() -> new IllegalArgumentException(
                        "Given team member isn't part of the provided engagement"));

        fields.forEach((key, value) -> {
            Field field = findField(TeamMember.class, key);
            if (isNull(field)) {
                throw new IllegalArgumentException("Specified field doesn't exist"); //TODO
            }
            field.setAccessible(true);
            if(key.equals("roles")) {
                roleRepository.deleteAll(toEdit.getRoles());
            }
            setField(field, toEdit, value);
        });
        toEdit.getRoles().forEach(role -> {
            role.setMember(toEdit);
            roleRepository.save(role);
        });
        return teamMemberRepository.save(toEdit);
    }

    private Engagement getEngagementById(String engagementId) {
        return engagementRepository.findById(engagementId).orElseThrow(
                () -> new IllegalArgumentException("Engagement with given ID not found"));
    }

    private User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new IllegalArgumentException("User with the given email doesn't exist"));
    }

    private void validateTeamMember(TeamMember teamMember, User user) {
        if (!user.getFullName().equals(teamMember.getName())) {
            throw new IllegalArgumentException("Specified username doesn't match");
        }
        if (!user.getUsername().equals(teamMember.getPwcGuid())) {
            throw new IllegalArgumentException("Pwc guid doesn't match");
        }
    }
}
