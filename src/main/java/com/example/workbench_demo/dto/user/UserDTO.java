package com.example.workbench_demo.dto.user;

import com.example.workbench_demo.model.User;
import com.example.workbench_demo.model.UserGroup;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties("authorizations")
public class UserDTO {
    private String username;
    private String email;
    private String country;

    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("pwc_country_code")
    private String pwcCountryCode;
    @JsonProperty("line_of_service")
    private String lineOfService;
    @JsonProperty("display_territory")
    private String displayTerritory;

    private List<String> groups;

    public User toUser() {
        User user = new User();

        user.setCountry(this.getCountry());
        user.setEmail(this.getEmail());
        user.setGroups(getGroups().stream().map(UserGroup::new).toList());
        user.setUsername(this.getUsername());
        user.setFirstName(this.getFirstName());
        user.setLastName(this.getLastName());
        user.setLineOfService(this.getLineOfService());
        user.setPwcCountryCode(this.getPwcCountryCode());
        return user;
    }
}
