package com.example.workbench_demo;

import com.example.workbench_demo.model.Client;
import com.example.workbench_demo.model.Engagement;
import com.example.workbench_demo.repository.ClientRepository;
import com.example.workbench_demo.repository.EngagementRepository;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WorkbenchDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(WorkbenchDemoApplication.class, args);
		ClientRepository clientRepository = context.getBean(ClientRepository.class);
		EngagementRepository engagementRepository = context.getBean(EngagementRepository.class);

		Client client = new Client();
		client.setId("1a13f631-63f3-4727-8de8-75a9f1d2f32y");
		client.setClientName("The other Geoff inc.");
		client.setSource("SDP");
		clientRepository.save(client);

		Engagement engagement = new Engagement();
		engagement.setClient(client);
		engagement.setId("7b04106c-28d7-4a69-8714-7a9a3a2217d2");
		engagement.setName("Engagement with Geoff inc.");
		engagement.setSearchable(true);
		engagement.setVisible(true);
		engagementRepository.save(engagement);

	}

}
