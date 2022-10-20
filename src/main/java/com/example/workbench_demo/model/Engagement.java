package com.example.workbench_demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
public class Engagement {
    @Id
    @Column(name = "id", nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String engagementType;
    private String workspaceType;
    private String territory; //Null
    private String territoryDetail;
    private String lineOfService;

    private Boolean searchable;
    private Boolean visible;

    private LocalDateTime createdDate;
    private LocalDate periodStart;
    private LocalDate periodEnd;

    private Client client;
    private EngagementTeamMember leader;
    private User createdBy; //empty
    private User deletedBy; //empty
    private List<EngagementTeamMember> users;
}
