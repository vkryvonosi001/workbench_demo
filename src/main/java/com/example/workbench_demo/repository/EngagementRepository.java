package com.example.workbench_demo.repository;

import com.example.workbench_demo.model.Engagement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngagementRepository extends JpaRepository<Engagement, String> {

    @Override
    boolean existsById(String s);
}