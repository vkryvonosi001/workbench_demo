package com.example.workbench_demo.service;

import com.example.workbench_demo.dto.request.UserDTO;
import com.example.workbench_demo.model.User;
import com.example.workbench_demo.repository.UserGroupRepository;
import com.example.workbench_demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserGroupRepository userGroupRepository;

    public UserService(UserRepository userRepository,
                       UserGroupRepository userGroupRepository) {
        this.userRepository = userRepository;
        this.userGroupRepository = userGroupRepository;
    }

    public void addUser(User user) {
        userRepository.save(user);
        user.getGroups().forEach(userGroup -> {
            userGroup.setUser(user);
            userGroupRepository.save(userGroup);
        });
    }

    public List<UserDTO> getUsersByCredential(String credential, boolean isExternal) {
        return userRepository.findByCredential(credential, credential,
                credential, credential, isExternal).stream()
                .map(UserDTO::new)
                .toList();
    }
}
