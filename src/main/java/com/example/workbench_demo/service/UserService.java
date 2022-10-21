package com.example.workbench_demo.service;

import com.example.workbench_demo.model.Engagement;
import com.example.workbench_demo.model.TeamMember;
import com.example.workbench_demo.model.User;
import com.example.workbench_demo.repository.EngagementRepository;
import com.example.workbench_demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final EngagementRepository engagementRepository;

    public UserService(UserRepository userRepository, EngagementRepository engagementRepository) {
        this.userRepository = userRepository;
        this.engagementRepository = engagementRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }
}
