package com.example.workbench_demo.controller;

import com.example.workbench_demo.dto.request.UserDTO;
import com.example.workbench_demo.service.EngagementUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/engagements")
public class EngagementUserController {
    private final EngagementUserService engagementUserService;

    public EngagementUserController(EngagementUserService engagementUserService) {
        this.engagementUserService = engagementUserService;
    }

    @GetMapping("{engagementId}/user/query")
    public ResponseEntity<Collection<UserDTO>> getAllUsersForEngagement(@RequestParam(name = "q")
                                                                        String userCredential,
                                                                        @RequestParam String type,
                                                                        @RequestParam String limit,
                                                                        @PathVariable String engagementId) {
        return ResponseEntity.ok(engagementUserService
                .getUsersForEngagementByCredential(userCredential, engagementId));
    }

    @GetMapping("{engagementId}/user/query/external")
    public ResponseEntity<Collection<UserDTO>> getExternalUsersForEngagement(@RequestParam(name = "q")
                                                                             String userCredential,
                                                                             @RequestParam String type,
                                                                             @RequestParam String limit,
                                                                             @PathVariable String engagementId) {
        return ResponseEntity.ok(engagementUserService
                .getUsersForEngagementByCredential(userCredential, engagementId, true));
    }

    @GetMapping("{engagementId}/user/query/internal")
    public ResponseEntity<Collection<UserDTO>> getInternalUsersForEngagement(@RequestParam(name = "q")
                                                                             String userCredential,
                                                                             @RequestParam String type,
                                                                             @RequestParam String limit,
                                                                             @PathVariable String engagementId) {
        return ResponseEntity.ok(engagementUserService
                .getUsersForEngagementByCredential(userCredential, engagementId, false));
    }

    @PostMapping("{engagementId}/search-users-by-emails")
    public ResponseEntity<Collection<UserDTO>> searchUsersByEmails(@PathVariable String engagementId,
                                                                   @RequestParam(defaultValue = "report",
                                                                           required = false) String limitType,
                                                                   @RequestBody List<String> values) {
        return ResponseEntity.ok(engagementUserService.getUsersForEngagementByEmail(values, engagementId));
    }

    @GetMapping("{engagementId}/user/external")
    public ResponseEntity<Collection<UserDTO>> getExternalUsersForEngagement(
            @RequestParam String type,
            @RequestParam String limit,
            @PathVariable String engagementId) {
        return ResponseEntity.ok(engagementUserService
                .getUsersForEngagement(engagementId, true));
    }
}
