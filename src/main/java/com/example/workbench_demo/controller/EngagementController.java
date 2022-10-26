package com.example.workbench_demo.controller;

import com.example.workbench_demo.dto.engagement.TeamMemberDTO;
import com.example.workbench_demo.model.User;
import com.example.workbench_demo.service.EngagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/engagements")
public class EngagementController {
    private final EngagementService engagementService;

    public EngagementController(EngagementService engagementService) {
        this.engagementService = engagementService;
    }

    @DeleteMapping("{engagementId}/user")
    public ResponseEntity<String> deleteTeamMember(@RequestBody TeamMemberDTO teamMemberDTO,
                                                   @PathVariable String engagementId) {
        engagementService.deleteTeamMember(teamMemberDTO.toTeamMember(), engagementId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("{engagementId}/search-users-by-emails")
    public ResponseEntity<Collection<User>> searchByEmails(@PathVariable String engagementId,
//   TODO - ask                                                        @RequestParam(defaultValue = "report",
//                                                                   required = false) String limitType,
                                                           @RequestBody List<String> values) {
        return ResponseEntity.ok(engagementService.getUsersForEngagementByEmail(values, engagementId));
    }

    @PostMapping("{engagementId}/user")
    public ResponseEntity<String> addTeamMember(@RequestBody TeamMemberDTO teamMemberDTO,
                                                @PathVariable String engagementId) {
        engagementService.addTeamMember(teamMemberDTO.toTeamMember(), engagementId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("{engagementId}/user")
    public ResponseEntity<String> editTeamMember(@RequestParam String email,
                                                 @RequestBody Map<String, Object> fields,
                                                 @PathVariable String engagementId) {
        engagementService.editTeamMember(fields, engagementId, email);
        return ResponseEntity.ok().build();
    }

    @PostMapping("{engagementId}/domains-config")
    public ResponseEntity<String> addDomains(@RequestBody List<String> domains,
                                             @RequestParam Boolean limitToClientRequest,
                                             @RequestParam Boolean limitToReportShare,
                                             @PathVariable String engagementId) {
        engagementService.addDomains(domains, engagementId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{engagementId}/domains-config")
    public ResponseEntity<List<String>> getDomains(@PathVariable String engagementId) {
        return ResponseEntity.ok(engagementService.getDomains(engagementId));
    }


}
