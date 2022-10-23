package com.example.workbench_demo;

import com.example.workbench_demo.controller.EngagementController;
import com.example.workbench_demo.controller.UserController;
import com.example.workbench_demo.dto.engagement.TeamMemberDTO;
import com.example.workbench_demo.dto.user.UserDTO;
import com.example.workbench_demo.model.Client;
import com.example.workbench_demo.model.Engagement;
import com.example.workbench_demo.model.Role;
import com.example.workbench_demo.model.UserGroup;
import com.example.workbench_demo.repository.ClientRepository;
import com.example.workbench_demo.repository.EngagementRepository;
import com.example.workbench_demo.repository.TeamMemberRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;

@SpringBootApplication
@EnableTransactionManagement
public class WorkbenchDemoApplication {

	public static void main(String[] args) throws IOException {
		ApplicationContext context = SpringApplication.run(WorkbenchDemoApplication.class, args);
		ClientRepository clientRepository = context.getBean(ClientRepository.class);
		EngagementRepository engagementRepository = context.getBean(EngagementRepository.class);
		EngagementController engagementController = context.getBean(EngagementController.class);

//		Client client = new Client();
//		client.setId("1a13f631-63f3-4727-8de8-75a9f1d2f32y");
//		client.setClientName("The Geoff inc.");
//		client.setSource("XDP");
//		clientRepository.save(client);
//
//		Engagement engagement = new Engagement();
//		engagement.setClient(client);
//		engagement.setId("7b04106c-28d7-4a69-8714-7a9a3a2217d2");
//		engagement.setName("Engagement with Geoff inc.");
//		engagement.setSearchable(true);
//		engagement.setVisible(true);
//		engagementRepository.save(engagement);
//
//		File f = new File(
//				"C:\\Users\\vkryvonosi001\\Downloads\\engagement_payload - Copy.json");
//		ObjectMapper objectMapper = new ObjectMapper();
//		UserDTO user = objectMapper.readValue(f, UserDTO.class);
//
//		context.getBean(UserController.class).addUser(user);

//		TeamMemberDTO teamMemberDTO = new TeamMemberDTO();
//		teamMemberDTO.setName("Jan Mikulaj");
//		teamMemberDTO.setEmail("jan.mikulaj@pwc.com");
//		teamMemberDTO.setRoles(asList("Lead", "architect"));
//		teamMemberDTO.setPwcGuid("idk001");
//		engagementController.addTeamMember(teamMemberDTO, "7b04106c-28d7-4a69-8714-7a9a3a2217d2");

		Map<String, Object> v = new HashMap<>();
		v.put("roles", new ArrayList<>(asList(new Role("Lead"), new Role("Manager"))));
		engagementController.editTeamMember("jan.mikulaj@pwc.com", v, "7b04106c-28d7-4a69-8714-7a9a3a2217d2"
				);
		context.getBean(TeamMemberRepository.class).findAll();
	}

}
