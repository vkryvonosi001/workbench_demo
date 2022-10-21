package com.example.workbench_demo.model;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class TeamMember {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "pwc_guid")
    private String pwcGuid;
    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "engagement_id", referencedColumnName = "id")
    private Engagement engagement;
    @OneToMany(mappedBy = "member")
    private List<Role> roles;
}
