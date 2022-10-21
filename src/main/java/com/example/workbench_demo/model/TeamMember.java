package com.example.workbench_demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "engagement_id", referencedColumnName = "id")
    private Engagement engagement;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private List<Role> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamMember that = (TeamMember) o;
        return pwcGuid.equals(that.pwcGuid) && email.equals(that.email) && Objects.equals(engagement, that.engagement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pwcGuid, email, engagement);
    }
}
