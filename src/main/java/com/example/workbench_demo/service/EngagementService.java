package com.example.workbench_demo.service;

import com.example.workbench_demo.model.Engagement;
import com.example.workbench_demo.model.TeamMember;
import com.example.workbench_demo.model.User;
import com.example.workbench_demo.repository.EngagementRepository;
import com.example.workbench_demo.repository.TeamMemberRepository;
import com.example.workbench_demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static org.springframework.util.ReflectionUtils.findField;
import static org.springframework.util.ReflectionUtils.setField;

@Service
public class EngagementService {
    private final EngagementRepository engagementRepository;
    private final UserRepository userRepository;
    private final TeamMemberRepository teamMemberRepository;

    public EngagementService(EngagementRepository engagementRepository,
                             UserRepository userRepository,
                             TeamMemberRepository teamMemberRepository) {
        this.engagementRepository = engagementRepository;
        this.userRepository = userRepository;
        this.teamMemberRepository = teamMemberRepository;
    }

    public List<User> getUsersForEngagementByEmail(List<String> emails, String engagementId) {
        Engagement engagement = engagementRepository.findById(engagementId).orElseThrow(
                () -> new IllegalArgumentException("User with given ID not found")); //TODO
        return engagement.getTeamMembers().stream()
                .filter(teamMember -> emails.contains(teamMember.getEmail()))
                .map(TeamMember::getUser)
                .collect(Collectors.toList());
    }

    public void deleteTeamMember(TeamMember teamMember, String engagementId) {
        Engagement engagement = engagementRepository.findById(engagementId).orElseThrow(
                () -> new IllegalArgumentException("Engagement with the given ID not found")); //TODO
        if (!engagement.getTeamMembers().contains(teamMember)) {
            throw new IllegalArgumentException("Given team member isn't part of the provided engagement");
        }
        engagement.getTeamMembers().remove(teamMember);
        engagementRepository.save(engagement);
    }

    public TeamMember addTeamMember(TeamMember teamMember, String engagementId) {
        User user = userRepository.findByEmail(teamMember.getEmail()).orElseThrow(
                () -> new IllegalArgumentException("User with the given ID doesn't exist")); //TODO

        Engagement engagement = engagementRepository.findById(engagementId).orElseThrow(
                () -> new IllegalArgumentException("Engagement with the given ID not found")); //TODO
        if (engagement.getTeamMembers().contains(teamMember)) {
            throw new IllegalArgumentException("Given team member is already part of the provided engagement");
        }
        teamMember.setEngagement(engagement);
        teamMember.setUser(user);
        return teamMemberRepository.save(teamMember);
    }

    public TeamMember editTeamMember(Map<String, Object> fields, String engagementId, String email) {
        Engagement engagement = engagementRepository.findById(engagementId).orElseThrow(
                () -> new IllegalArgumentException("Engagement with the given ID not found")); //TODO

        TeamMember toEdit = engagement.getTeamMembers().stream()
                .filter(teamMember -> teamMember.getEmail().equals(email))
                .findFirst().orElseThrow(() -> new IllegalArgumentException(
                        "Given team member isn't part of the provided engagement"));

        fields.forEach((key, value) -> {
            Field field = findField(TeamMember.class, key);
            if(isNull(field)) {
                throw new IllegalArgumentException("Specified field doesn't exist"); //TODO
            }
            field.setAccessible(true);
            setField(field, toEdit, value);
        });
        return teamMemberRepository.save(toEdit);
    }
}
