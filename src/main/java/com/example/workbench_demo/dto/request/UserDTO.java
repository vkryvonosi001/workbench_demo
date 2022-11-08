package com.example.workbench_demo.dto.request;

import com.example.workbench_demo.model.User;
import com.example.workbench_demo.model.UserGroup;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    private Boolean isExternal;

    private List<String> groups;

    public UserDTO(User user) {
        this.country = user.getCountry();
        this.email = user.getEmail();
        this.groups = user.getGroups().stream().map(UserGroup::getName).collect(Collectors.toList());
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.lineOfService = user.getLineOfService();
        this.pwcCountryCode = user.getPwcCountryCode();
        this.displayTerritory = user.getDisplayTerritory();
    }

    public User toUser() {
        User user = new User();

        user.setCountry(this.getCountry());
        user.setEmail(this.getEmail());
        user.setGroups(getGroups().stream().map(UserGroup::new).collect(Collectors.toList()));
        user.setUsername(this.getUsername());
        user.setFirstName(this.getFirstName());
        user.setLastName(this.getLastName());
        user.setLineOfService(this.getLineOfService());
        user.setPwcCountryCode(this.getPwcCountryCode());
        user.setDisplayTerritory(this.displayTerritory);
        user.setIsExternal(this.isExternal);
        return user;
    }
}
