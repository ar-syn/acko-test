package com.example.security.securityDemo.App;

import com.example.security.securityDemo.Developer.DTO.DeveloperDTO;
import com.example.security.securityDemo.Team.DTO.TeamDTO;

import java.util.List;

public class CreateTeamRequestDTO {

    private TeamDTO team;

    private List<DeveloperDTO> developers;

    public TeamDTO getTeam() {
        return team;
    }

    public void setTeam(TeamDTO team) {
        this.team = team;
    }

    public List<DeveloperDTO> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<DeveloperDTO> developers) {
        this.developers = developers;
    }
}
