package com.example.workbench_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class WorkbenchDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkbenchDemoApplication.class, args);
    }

}
