package com.example.workbench_demo.dto.request;

import com.example.workbench_demo.model.Role;
import com.example.workbench_demo.model.TeamMember;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamMemberDTO {

    private String pwcGuid;
    private String name;
    private String email;

    private List<String> roles;

    public TeamMemberDTO(TeamMember teamMember) {
        this.pwcGuid = teamMember.getPwcGuid();
        this.name = teamMember.getName();
        this.email = teamMember.getEmail();
        this.roles = teamMember.getRoles().stream().map(Role::getTitle).toList();
    }

    public TeamMember toTeamMember() {
        TeamMember teamMember = new TeamMember();

        teamMember.setEmail(this.getEmail());
        teamMember.setName(this.getName());
        teamMember.setPwcGuid(this.getPwcGuid());
        teamMember.setRoles(this.getRoles().stream().map(Role::new).toList());
        return teamMember;
    }
}