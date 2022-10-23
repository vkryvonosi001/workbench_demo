package com.example.workbench_demo.service;

import com.example.workbench_demo.model.User;
import com.example.workbench_demo.repository.EngagementRepository;
import com.example.workbench_demo.repository.UserGroupRepository;
import com.example.workbench_demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserGroupRepository userGroupRepository;
    private final EngagementRepository engagementRepository;

    public UserService(UserRepository userRepository, UserGroupRepository userGroupRepository, EngagementRepository engagementRepository) {
        this.userRepository = userRepository;
        this.userGroupRepository = userGroupRepository;
        this.engagementRepository = engagementRepository;
    }

    public User addUser(User user) {
        userRepository.save(user);
        user.getGroups().forEach(userGroup -> {
            userGroup.setUser(user);
            userGroupRepository.save(userGroup);
        });
        return user;
    }
}
