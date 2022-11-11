package com.example.workbench_demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name="engagement")
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
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;
    @ManyToOne
    @JoinColumn(name = "deleted_by")
    private User deletedBy;

    @OneToMany(mappedBy = "engagement")
    private List<TeamMember> teamMembers;
    @OneToMany(mappedBy = "engagement")
    private List<Domain> domains;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engagement that = (Engagement) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
