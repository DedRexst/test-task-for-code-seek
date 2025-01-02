package com.testtaskforcodeseek.controllers;

import com.testtaskforcodeseek.dtos.requests.PatchTeamDto;
import com.testtaskforcodeseek.dtos.requests.PostTeamDto;
import com.testtaskforcodeseek.dtos.responses.GetTeamDto;
import com.testtaskforcodeseek.services.TeamsCrudService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/teams")
@RequiredArgsConstructor
public class TeamsCrudController {
    private final TeamsCrudService teamsCrudService;

    @PostMapping
    public GetTeamDto postTeam(@Valid @RequestBody PostTeamDto postTeamDto) {
        return teamsCrudService.postTeam(postTeamDto);
    }

    @GetMapping
    public Page<GetTeamDto> getTeams(Pageable pageable) {
        return teamsCrudService.getTeams(pageable);
    }

    @GetMapping("/by-id")
    public GetTeamDto getTeam(@PathParam("id") UUID id) {
        return teamsCrudService.getTeam(id);
    }

    @PatchMapping
    public void patchTeam(@Valid @RequestBody PatchTeamDto patchTeamDto) {
        teamsCrudService.patchTeam(patchTeamDto);
    }

    @DeleteMapping
    public void deleteTeam(@PathParam("id") UUID id) {
        teamsCrudService.deleteTeam(id);
    }
}
