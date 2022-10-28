package com.example.workbench_demo.controller;

import com.example.workbench_demo.dto.user.UserDTO;
import com.example.workbench_demo.service.EngagementService;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/engagements")
public class EngagementController {
    private final EngagementService engagementService;

    public EngagementController(EngagementService engagementService) {
        this.engagementService = engagementService;
    }

    @GetMapping("{engagementId}/user")
    public ResponseEntity<Collection<UserDTO>> getUserForEngagement(@RequestParam(name = "q")
                                                                    String userCredential,
                                                                    @RequestParam String type,
                                                                    @RequestParam String limit,
                                                                    @PathVariable String engagementId) {
        return ResponseEntity.ok(engagementService
                .getUsersForEngagementByCredential(userCredential, engagementId));
    }

    @PostMapping("{engagementId}/search-users-by-emails")
    public ResponseEntity<Collection<UserDTO>> searchByEmails(@PathVariable String engagementId,
//   TODO - ask                                                        @RequestParam(defaultValue = "report",
//                                                                   required = false) String limitType,
                                                              @RequestBody List<String> values) {
        return ResponseEntity.ok(engagementService.getUsersForEngagementByEmail(values, engagementId));
    }
}
