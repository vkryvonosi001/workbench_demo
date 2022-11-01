package com.example.workbench_demo.service;

import com.example.workbench_demo.model.Engagement;
import com.example.workbench_demo.model.TeamMember;
import com.example.workbench_demo.model.User;
import com.example.workbench_demo.repository.EngagementRepository;
import com.example.workbench_demo.repository.RoleRepository;
import com.example.workbench_demo.repository.TeamMemberRepository;
import com.example.workbench_demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.Map;

import static com.example.workbench_demo.service.Utils.*;
import static java.util.Objects.isNull;
import static org.springframework.util.ReflectionUtils.findField;
import static org.springframework.util.ReflectionUtils.setField;

@Service
@Transactional
public class TeamMemberService {

    private final UserRepository userRepository;
    private final EngagementRepository engagementRepository;
    private final RoleRepository roleRepository;
    private final TeamMemberRepository teamMemberRepository;

    public TeamMemberService(UserRepository userRepository,
                             EngagementRepository engagementRepository,
                             RoleRepository roleRepository,
                             TeamMemberRepository teamMemberRepository) {
        this.userRepository = userRepository;
        this.engagementRepository = engagementRepository;
        this.roleRepository = roleRepository;
        this.teamMemberRepository = teamMemberRepository;
    }

    public void deleteTeamMember(TeamMember teamMember, String engagementId) {
        Engagement engagement = getEngagementById(engagementId, engagementRepository);
        teamMember.setEngagement(engagement);

        teamMemberRepository.deleteById(getTeamMemberId(teamMember, engagement));
    }

    public void addTeamMember(TeamMember teamMember, String engagementId) {
        User user = getUserByEmail(teamMember.getEmail(), userRepository);
        Engagement engagement = getEngagementById(engagementId, engagementRepository);

        teamMember.setEngagement(engagement);

        if (engagement.getTeamMembers().contains(teamMember)) {
            throw new IllegalArgumentException("Given team member is already part of the provided engagement");
        }
        validateTeamMember(teamMember, user);

        teamMember.setUser(user);
        teamMemberRepository.save(teamMember);

        teamMember.getRoles().forEach(role -> {
            role.setMember(teamMember);
            roleRepository.save(role);
        });
    }

    public void editTeamMember(Map<String, Object> fields, String engagementId, String email) {
        verifyEngagementExists(engagementId, engagementRepository);
        TeamMember toEdit = teamMemberRepository.findByEmailAndEngagementId(email, engagementId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Given team member isn't part of the provided engagement"));

        fields.forEach((key, value) -> {
            Field field = findField(TeamMember.class, key);
            if (isNull(field)) {
                throw new IllegalArgumentException("Specified field doesn't exist"); //TODO
            }
            field.setAccessible(true);
            if (key.equals("roles")) {
                roleRepository.deleteAll(toEdit.getRoles());
            }
            setField(field, toEdit, value);
        });

        toEdit.getRoles().forEach(role -> {
            role.setMember(toEdit);
            roleRepository.save(role);
        });
    }
}
