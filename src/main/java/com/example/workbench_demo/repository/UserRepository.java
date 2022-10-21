package com.example.workbench_demo.repository;

import com.example.workbench_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmails(List<String> emails);

    boolean existsByEmail(String email);

}