package com.example.workbench_demo.service;

import com.example.workbench_demo.model.TeamMember;
import com.example.workbench_demo.model.User;
import com.example.workbench_demo.repository.EngagementRepository;
import com.example.workbench_demo.repository.TeamMemberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EngagementService {
    private final EngagementRepository engagementRepository;
    private final TeamMemberRepository teamMemberRepository;

    public EngagementService(EngagementRepository engagementRepository,
                             TeamMemberRepository teamMemberRepository) {
        this.engagementRepository = engagementRepository;
        this.teamMemberRepository = teamMemberRepository;
    }

    public List<User> getUsersForEngagementByEmail(List<String> emails, String engagementId) {
        if(!engagementRepository.existsById(engagementId)) {
            throw new IllegalArgumentException("Engagement with given ID not found");
        }
        return teamMemberRepository.findByEmailInAndEngagement_Id(emails, engagementId)
                .map(TeamMember::getUser).toList();
    }
}
