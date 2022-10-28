package com.example.workbench_demo.controller;

import com.example.workbench_demo.dto.user.UserDTO;
import com.example.workbench_demo.model.User;
import com.example.workbench_demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user")
    public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.addUser(userDTO.toUser()));
    }
}
