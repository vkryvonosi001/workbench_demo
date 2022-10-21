package com.example.workbench_demo.repository;

import com.example.workbench_demo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
}