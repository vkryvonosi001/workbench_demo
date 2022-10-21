package com.example.workbench_demo.service;

import com.example.workbench_demo.model.Engagement;
import com.example.workbench_demo.model.TeamMember;
import com.example.workbench_demo.model.User;
import com.example.workbench_demo.repository.EngagementRepository;
import com.example.workbench_demo.repository.TeamMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EngagementService {
    private final EngagementRepository engagementRepository;
    private final TeamMemberRepository teamMemberRepository;

    public EngagementService(EngagementRepository engagementRepository, TeamMemberRepository teamMemberRepository) {
        this.engagementRepository = engagementRepository;
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
                () -> new IllegalArgumentException("User with given ID not found")); //TODO
        if (!engagement.getTeamMembers().contains(teamMember)) {
            throw new IllegalArgumentException("Given team member isn't part of the provided engagement");
        }
        engagement.getTeamMembers().remove(teamMember);
        engagementRepository.save(engagement);

    }

    public void addTeamMember(TeamMember teamMember, String engagementId) {
        Engagement engagement = engagementRepository.findById(engagementId).orElseThrow(
                () -> new IllegalArgumentException("User with given ID not found")); //TODO
        if (engagement.getTeamMembers().contains(teamMember)) {
            throw new IllegalArgumentException("Given team member isn't part of the provided engagement");
        }
        engagement.getTeamMembers().add(teamMember);
        engagementRepository.save(engagement);

    }

}
