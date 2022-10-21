package com.example.workbench_demo.repository;

import com.example.workbench_demo.model.Engagement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EngagementRepository extends JpaRepository<Engagement, String> {

}