package com.testtaskforcodeseek.services.impl;

import com.testtaskforcodeseek.dtos.requests.PatchTeamDto;
import com.testtaskforcodeseek.dtos.requests.PostTeamDto;
import com.testtaskforcodeseek.dtos.responses.GetTeamDto;
import com.testtaskforcodeseek.entities.Team;
import com.testtaskforcodeseek.mappers.TeamMapper;
import com.testtaskforcodeseek.repositories.TeamRepository;
import com.testtaskforcodeseek.services.TeamsCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeamsCrudServiceImpl implements TeamsCrudService {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Override
    @Transactional
    public GetTeamDto postTeam(PostTeamDto postTeamDto) {
        Team team = teamMapper.dtoToEntity(postTeamDto);
        team.setPlayers(new ArrayList<>());
        return teamMapper.entityToDto(teamRepository.save(team));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<GetTeamDto> getTeams(Pageable pageable) {
        return teamRepository.findAll(pageable).map(teamMapper::entityToDto);
    }

    @Override
    @Transactional
    public void patchTeam(PatchTeamDto patchTeamDto) {
        Team team = teamRepository.findById(patchTeamDto.id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Team with this id don't exists"));
        teamMapper.updateEntityFromDto(patchTeamDto, team);
    }

    @Override
    @Transactional(readOnly = true)
    public GetTeamDto getTeam(UUID id) {
        return teamMapper.entityToDto(teamRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Team with this id don't exists")));
    }

    @Override
    @Transactional
    public void deleteTeam(UUID id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Team with this id don't exists"));
        team.getPlayers().clear();
        teamRepository.save(team);
        teamRepository.delete(team);
    }
}
