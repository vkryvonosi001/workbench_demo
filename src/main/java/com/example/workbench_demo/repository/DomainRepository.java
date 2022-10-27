package com.example.workbench_demo.repository;

import com.example.workbench_demo.model.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainRepository extends JpaRepository<Domain, Long> {
}