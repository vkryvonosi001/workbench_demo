package com.example.workbench_demo.service;

import com.example.workbench_demo.dto.user.UserDTO;
import com.example.workbench_demo.exception.NotMemberOfGivenEngagement;
import com.example.workbench_demo.model.TeamMember;
import com.example.workbench_demo.repository.EngagementRepository;
import com.example.workbench_demo.repository.TeamMemberRepository;
import com.example.workbench_demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.example.workbench_demo.service.Utils.verifyEngagementExists;

@Service
@Transactional
public class EngagementService {
    private final UserRepository userRepository;
    private final EngagementRepository engagementRepository;
    private final TeamMemberRepository teamMemberRepository;

    public EngagementService(UserRepository userRepository,
                             EngagementRepository engagementRepository,
                             TeamMemberRepository teamMemberRepository) {
        this.userRepository = userRepository;
        this.engagementRepository = engagementRepository;
        this.teamMemberRepository = teamMemberRepository;
    }

    public List<UserDTO> getUsersForEngagementByEmail(List<String> emails, String engagementId) {
        verifyEngagementExists(engagementId, engagementRepository);
        return teamMemberRepository.findByEmailsAndEngagementId(emails, engagementId)
                .map(member -> new UserDTO(member.getUser())).toList();
    }

    public List<UserDTO> getUsersForEngagementByCredential(String credential, String engagementId) {
        verifyEngagementExists(engagementId, engagementRepository);

        List<TeamMember> response = teamMemberRepository
                .findByCredentialAndEngagementId(credential, credential, engagementId);

        validateCredentialSearchResponse(response, credential, engagementId);
        return response.stream()
                .map(member -> new UserDTO(member.getUser())).toList();
    }

    private void validateCredentialSearchResponse(List<TeamMember> response, String credential,
                                                  String engagementId) {
        if (response.size() > 5000) {
            throw new IllegalArgumentException(
                    "5000 limit value exceeded with current config limit value: 500");
        }
        if (response.size() == 0) {
            if (userRepository.existsByEmailContainsOrUsernameContains(credential, credential)) {
                throw new NotMemberOfGivenEngagement(String.format("%s not a member of %s",
                        credential, engagementId));
            }
        }
    }
}
