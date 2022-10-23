package com.example.workbench_demo.controller;

import com.example.workbench_demo.dto.engagement.TeamMemberDTO;
import com.example.workbench_demo.model.TeamMember;
import com.example.workbench_demo.model.User;
import com.example.workbench_demo.service.EngagementService;
import com.example.workbench_demo.service.UserService;
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
    public ResponseEntity<TeamMember> addTeamMember(@RequestBody TeamMemberDTO teamMemberDTO,
                                                    @PathVariable String engagementId) {
        TeamMember saved = engagementService.addTeamMember(teamMemberDTO.toTeamMember(), engagementId);
        return ResponseEntity.ok(saved);
    }

    @PatchMapping("{engagementId}/user")
    public ResponseEntity<TeamMember> editTeamMember(@RequestParam String email,
                                                @RequestBody Map<String, Object> fields,
                                                @PathVariable String engagementId) {
        TeamMember edited = engagementService.editTeamMember(fields, engagementId, email);
        return  ResponseEntity.ok(edited);
    }

}
