package com.example.Workbench_demo;

import com.example.workbench_demo.repository.TeamMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@TestPropertySource("/application-test.properties")
@Sql(value = "/dataset/teamMemberData.sql")
class WorkbenchDemoApplicationTests {
	@Autowired
	private TeamMemberRepository teamMemberRepository;

	@Test
	void contextLoads() {
		System.out.println(teamMemberRepository.findAll().size());
	}

}
