package com.example.workbench_demo.service;

import com.example.workbench_demo.model.Domain;
import com.example.workbench_demo.model.Engagement;
import com.example.workbench_demo.repository.DomainRepository;
import com.example.workbench_demo.repository.EngagementRepository;
import com.example.workbench_demo.repository.TeamMemberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.workbench_demo.service.Utils.*;

@Service
@Transactional
public class DomainService {
    private final EngagementRepository engagementRepository;
    private final DomainRepository domainRepository;
    private final TeamMemberRepository teamMemberRepository;

    public DomainService(EngagementRepository engagementRepository,
                         DomainRepository domainRepository,
                         TeamMemberRepository teamMemberRepository) {
        this.engagementRepository = engagementRepository;
        this.domainRepository = domainRepository;
        this.teamMemberRepository = teamMemberRepository;
    }

    public void addDomains(List<String> domainNames, String engagementId) {
        Engagement engagement = getEngagementById(engagementId, engagementRepository);
        List<Long> currentDomainIds = engagement.getDomains().stream()
                .map(Domain::getId).collect(Collectors.toList());
        List<String> regexes = domainNames.stream()
                .map(name -> String.format(EMAIL_DOMAIN_REGEX, name)).collect(Collectors.toList());

        domainRepository.deleteAllById(currentDomainIds);
        domainNames.forEach(domainName ->
                domainRepository.save(new Domain(domainName, engagement)));
        engagement.getTeamMembers().forEach(teamMember -> {
            if (regexes.stream().noneMatch(regex -> teamMember.getEmail().matches(regex))) {
                teamMemberRepository.deleteById(getTeamMemberId(teamMember, engagement));
            }
        });
    }

    public List<String> getDomains(String engagementId) {
        Engagement engagement = getEngagementById(engagementId, engagementRepository);
        return engagement.getDomains().stream().map(Domain::getName).collect(Collectors.toList());
    }
}
