package com.example.workbench_demo.repository;

import com.example.workbench_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    boolean existsByEmailContainsOrUsernameContains(String email, String username);

    @Query("select u from User u " +
            "where (upper(u.email) like upper(concat('%', ?1, '%')) or upper(u.lastName) like upper(concat('%', ?2, '%')) or upper(u.firstName) like upper(concat('%', ?3, '%')) or upper(u.username) like upper(concat('%', ?4, '%'))) and u.isExternal = ?5")
    List<User> findByCredential(String email, String lastName, String firstName, String username, Boolean isExternal);



}