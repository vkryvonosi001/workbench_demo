package com.example.workbench_demo.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TerritoryDetail {
	private Long id;
	private String name;
	private String group;
	private String cloudRegion;
	private String abbreviation;

	private Boolean office;
	private Boolean workbenchAuthorized;
	private Boolean extractManagerAuthorized;
	private Boolean digitalLabEnabled;

	private LocalDateTime createdDate;
	private LocalDateTime lastModifiedDate;
}
