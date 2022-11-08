package com.example.workbench_demo.controller;

import com.example.workbench_demo.dto.request.TeamMemberDTO;
import com.example.workbench_demo.service.TeamMemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/engagements")
public class TeamMemberController {
    private final TeamMemberService teamMemberService;

    public TeamMemberController(TeamMemberService teamMemberService) {
        this.teamMemberService = teamMemberService;
    }

    @DeleteMapping("{engagementId}/user")
    public ResponseEntity<String> deleteTeamMember(@RequestBody TeamMemberDTO teamMemberDTO,
                                                   @PathVariable String engagementId) {
        teamMemberService.deleteTeamMember(teamMemberDTO.toTeamMember(), engagementId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("{engagementId}/user")
    public ResponseEntity<String> addTeamMember(@RequestBody TeamMemberDTO teamMemberDTO,
                                                @PathVariable String engagementId) {
        teamMemberService.addTeamMember(teamMemberDTO.toTeamMember(), engagementId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("{engagementId}/user")
    public ResponseEntity<String> editTeamMember(@RequestParam String email,
                                                 @RequestBody Map<String, Object> fields, //TODO Map<String, String>?
                                                 @PathVariable String engagementId) {
        teamMemberService.editTeamMember(fields, engagementId, email);
        return ResponseEntity.ok().build();
    }
}
