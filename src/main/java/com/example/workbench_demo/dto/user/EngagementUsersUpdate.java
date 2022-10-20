package com.example.workbench_demo.dto.user;

import com.example.workbench_demo.model.User;
import lombok.Data;

import java.util.List;

@Data
public class EngagementUsersUpdate {
	private final List<User> added;
	private final List<User> edited;
	private final List<User> removed;
}
