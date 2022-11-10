package com.example.Workbench_demo.service;

import com.example.workbench_demo.model.Domain;
import com.example.workbench_demo.model.Engagement;
import com.example.workbench_demo.repository.DomainRepository;
import com.example.workbench_demo.repository.EngagementRepository;
import com.example.workbench_demo.service.TeamMemberService;
import com.example.workbench_demo.service.Utils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class DomainServiceTest {
    @Autowired
    private EngagementRepository engagementRepository;
    @Autowired
    private TeamMemberService teamMemberService;

    @Test
    void testDeleteTeamMember() {

    }
}
