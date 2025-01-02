package com.testtaskforcodeseek.services;

import com.testtaskforcodeseek.dtos.requests.PatchTeamDto;
import com.testtaskforcodeseek.dtos.requests.PostTeamDto;
import com.testtaskforcodeseek.dtos.responses.GetTeamDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface TeamsCrudService {
    GetTeamDto postTeam(PostTeamDto postTeamDto);

    Page<GetTeamDto> getTeams(Pageable pageable);

    void patchTeam(PatchTeamDto patchTeamDto);

    GetTeamDto getTeam(UUID id);

    void deleteTeam(UUID id);
}
