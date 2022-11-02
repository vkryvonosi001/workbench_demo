package com.example.workbench_demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    private String email;
    private String country;
    @Column(name = "pwc_country_code")
    private String pwcCountryCode;
    @Column(name = "line_of_service")
    private String lineOfService;
    @Column(name = "display_territory")
    private String displayTerritory;

    @Column(name = "is_external")
    private Boolean isExternal;

    @OneToMany(mappedBy = "user")
    private List<UserGroup> groups;

//    private List<Authorization> authorizations;

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
}
