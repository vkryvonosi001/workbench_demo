package com.example.workbench_demo.dto.engagement;

import com.example.workbench_demo.model.Role;
import com.example.workbench_demo.model.TeamMember;
import lombok.Data;

import java.util.List;

@Data
public class TeamMemberDTO {

    private String pwcGuid;
    private String name;
    private String email;

    private List<String> roles;

    public TeamMember toTeamMember() {
        TeamMember teamMember = new TeamMember();

        teamMember.setEmail(this.getEmail());
        teamMember.setName(this.getName());
        teamMember.setPwcGuid(this.getPwcGuid());
        teamMember.setRoles(this.getRoles().stream().map(Role::new).toList());
        return teamMember;
    }
}