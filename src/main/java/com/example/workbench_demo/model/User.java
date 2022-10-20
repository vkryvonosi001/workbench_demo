package com.example.workbench_demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String country;
    private String pwcCountryCode;
    private String lineOfService;
    private String displayTerritory;

    private List<UserGroup> group;
    private List<Authorization> authorizations;

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
}
