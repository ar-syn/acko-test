package com.example.security.securityDemo.App;

import com.example.security.securityDemo.Developer.DTO.DeveloperDTO;
import com.example.security.securityDemo.Developer.Model.Developer;
import com.example.security.securityDemo.Developer.Repository.DeveloperRepository;
import com.example.security.securityDemo.Team.Model.Team;
import com.example.security.securityDemo.Team.Repository.TeamRepository;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(value = "/v1")
public class AppController {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    DeveloperRepository developerRepository;

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    @PostMapping(value = "/create-team")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody CreateTeamRequestDTO createTeam(@RequestBody CreateTeamRequestDTO createTeamRequestDTO){
        CreateTeamRequestDTO createTeamRequestDTO1 = new CreateTeamRequestDTO();
        Team team = new Team();
        team.setId(UUID.randomUUID());
        team.setName(createTeamRequestDTO.getTeam().getName());
        createTeamRequestDTO1.setTeam(createTeamRequestDTO.getTeam());
        createTeamRequestDTO1.getTeam().setId(team.getId());
        teamRepository.save(team);
        List<DeveloperDTO> developerDTOList = new ArrayList<>();
        createTeamRequestDTO.getDevelopers().forEach(developerDTO -> {
            Developer developer = new Developer();
            developer.setId(UUID.randomUUID());
            developer.setName(developerDTO.getName());
            developer.setTeamId(team.getId());
            developer.setPhoneNumber(developerDTO.getPhoneNumber());
            developerRepository.save(developer);
            developerDTO.setTeamId(team.getId());
            developerDTO.setId(developer.getId());
            developerDTOList.add(developerDTO);
        });
        createTeamRequestDTO1.setDevelopers(developerDTOList);
        return createTeamRequestDTO1;
    }

    @PostMapping(value = "/alert")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String createTeam(@RequestParam UUID teamId) throws IOException {
        List<Developer> developerList = developerRepository.findDeveloperByTeamId(teamId);
        OkHttpClient client = new OkHttpClient();
        Optional<Developer> developer = developerList.stream().findAny();
        String json = "{\"phone_number\":\"" + developer.get().getPhoneNumber() +"\",\"message\":\"Too Many 5xx!!\"}";

        okhttp3.RequestBody body = okhttp3.RequestBody.create(JSON, json);

        Request request = new Request.Builder()
                .url("https://run.mocky.io/v3/fd99c100-f88a-4d70-aaf7-393dbbd5d99f")
                .post(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        return response.body().toString();
    }

}
