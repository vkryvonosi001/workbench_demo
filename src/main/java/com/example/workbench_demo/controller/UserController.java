package com.example.workbench_demo.controller;

import com.example.workbench_demo.dto.user.UserDTO;
import com.example.workbench_demo.model.User;
import com.example.workbench_demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/api/v1/")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("users/search")
    public ResponseEntity<?> searchUsers(
            @RequestParam(defaultValue = "Email", required = false) String property,
            @RequestParam(defaultValue = "Internal", required = false) String type,
            @RequestBody List<?> values) { //TODO
        return null;
    }

    @PostMapping("engagements/{engagementId}/search-users-by-emails")
    public ResponseEntity<Collection<User>> searchByEmails(@RequestParam String engagementId,
                                                           @RequestParam(defaultValue = "report", required = false) String limitType,
                                                           @RequestBody List<String> values) {
        return ResponseEntity.ok(userService.getUsersForEngagementByEmail(values, engagementId));
    }

    @GetMapping("engagements/{engagementId}/search-users")
    public ResponseEntity<?> searchWithValidation(@RequestParam String engagementId,
                                                  @RequestParam(defaultValue = "report", required = false) String limitType,
                                                  @RequestParam String q) {
        return null;
    }

    @PutMapping("users/{engagementId}")
    public ResponseEntity<?> updateUsers(@RequestParam String engagementId,
                                         //TODO - get requester and ask if we need =>  @RequestParam(defaultValue = "report", required = false) String limitType,
                                         @RequestBody UserDTO request) {
        return null;
    }

    @GetMapping("profile/{userGuid}")
    public ResponseEntity<?> getUserProfileImage(@RequestParam String userGuid) {
        return null;
    }

    @PostMapping("user")
    public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.addUser(userDTO.toUser()));
    }

}
