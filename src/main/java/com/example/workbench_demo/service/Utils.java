package com.example.workbench_demo.service;

import com.example.workbench_demo.model.Engagement;
import com.example.workbench_demo.model.TeamMember;
import com.example.workbench_demo.model.User;
import com.example.workbench_demo.repository.EngagementRepository;
import com.example.workbench_demo.repository.UserRepository;

public final class Utils {
    public static final String EMAIL_DOMAIN_REGEX = "^[a-zA-Z0-9_\\\\.]+@%s$";
    public static Engagement getEngagementById(String engagementId,
                                               EngagementRepository engagementRepository) {
        return engagementRepository.findById(engagementId).orElseThrow(
                () -> new IllegalArgumentException("Engagement with given ID not found"));
    }

    public static User getUserByEmail(String email, UserRepository userRepository) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new IllegalArgumentException("User with the given email doesn't exist"));
    }

    public static void validateTeamMember(TeamMember teamMember, User user) {
        if (!user.getFullName().equals(teamMember.getName())) {
            throw new IllegalArgumentException("Specified username doesn't match");
        }
        if (!user.getUsername().equals(teamMember.getPwcGuid())) {
            throw new IllegalArgumentException("Pwc guid doesn't match");
        }
    }

    public static Long getTeamMemberId(TeamMember teamMember, Engagement engagement) {
        return engagement.getTeamMembers().stream()
                .filter(member -> member.equals(teamMember))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Given team member" +
                        " isn't part of the provided engagement")).getId();
    }
}
