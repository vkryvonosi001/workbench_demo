package com.example.workbench_demo.controller;

import com.example.workbench_demo.dto.request.UserDTO;
import com.example.workbench_demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/user/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO) {
        userService.addUser(userDTO.toUser());
        return ResponseEntity.ok().build();
    }

    @GetMapping("query/external")
    public ResponseEntity<Collection<UserDTO>> getExternalUsers(@RequestParam(name = "q")
                                                                String userCredential,
                                                                @RequestParam String type,
                                                                @RequestParam String limit) {
        return ResponseEntity.ok(userService.getUsersByCredential(userCredential, true));
    }

    @GetMapping("query/internal")
    public ResponseEntity<Collection<UserDTO>> getInternalUsers(@RequestParam(name = "q")
                                                                String userCredential,
                                                                @RequestParam String type,
                                                                @RequestParam String limit) {
        return ResponseEntity.ok(userService.getUsersByCredential(userCredential, false));
    }
}
