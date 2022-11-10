package com.example.Workbench_demo.controller;

import com.example.workbench_demo.controller.DomainController;
import com.example.workbench_demo.service.DomainService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(MockitoExtension.class)
class DomainControllerTest {
	private ObjectMapper mapper;
	private MockMvc mockMvc;

	@Mock
	private DomainService domainService;

	@InjectMocks
	private DomainController domainController;

	@Test
	void contextLoads() {
	}

}
