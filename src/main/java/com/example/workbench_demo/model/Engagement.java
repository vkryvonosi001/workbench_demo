package com.example.workbench_demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Engagement {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String name;
    @Column(name = "engagement_type")
    private String engagementType;
    @Column(name = "workspace_type")
    private String workspaceType;
    private String territory;
//    @Column(name = "territory_detail")
//    private String territoryDetail;
    @Column(name = "line_of_service")
    private String lineOfService;

    private Boolean searchable;
    private Boolean visible;

    @Column(name = "period_start")
    private LocalDate periodStart;
    @Column(name = "period_end")
    private LocalDate periodEnd;

    @ManyToOne
    @JoinColumn(name = "client", referencedColumnName = "id")
    private Client client;
    @OneToOne
    @JoinColumn(name = "leader")
    private TeamMember leader;
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;
    @ManyToOne
    @JoinColumn(name = "deleted_by")
    private User deletedBy;
    @OneToMany(mappedBy = "engagement")
    private List<TeamMember> users;
}
