package com.example.workbench_demo.repository;

import com.example.workbench_demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}