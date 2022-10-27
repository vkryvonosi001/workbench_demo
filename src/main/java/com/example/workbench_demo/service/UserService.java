package com.example.workbench_demo.service;

import com.example.workbench_demo.model.User;
import com.example.workbench_demo.repository.EngagementRepository;
import com.example.workbench_demo.repository.UserGroupRepository;
import com.example.workbench_demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserGroupRepository userGroupRepository;

    public UserService(UserRepository userRepository, UserGroupRepository userGroupRepository) {
        this.userRepository = userRepository;
        this.userGroupRepository = userGroupRepository;
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
