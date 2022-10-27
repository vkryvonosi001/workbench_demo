package com.example.workbench_demo.service;

import com.example.workbench_demo.model.Engagement;
import com.example.workbench_demo.model.TeamMember;
import com.example.workbench_demo.model.User;
import com.example.workbench_demo.repository.EngagementRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.workbench_demo.service.Utils.getEngagementById;

@Service
@Transactional
public class EngagementService {
    private final EngagementRepository engagementRepository;

    public EngagementService(EngagementRepository engagementRepository) {
        this.engagementRepository = engagementRepository;
    }

    public List<User> getUsersForEngagementByEmail(List<String> emails, String engagementId) {
        Engagement engagement = getEngagementById(engagementId, engagementRepository);
        return engagement.getTeamMembers().stream()
                .filter(teamMember -> emails.contains(teamMember.getEmail()))
                .map(TeamMember::getUser)
                .collect(Collectors.toList());
    }
}
