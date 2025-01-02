package com.testtaskforcodeseek.services.impl;

import com.testtaskforcodeseek.dtos.requests.PatchPlayerDto;
import com.testtaskforcodeseek.dtos.requests.PostPlayerDto;
import com.testtaskforcodeseek.dtos.responses.GetPlayerDto;
import com.testtaskforcodeseek.entities.Player;
import com.testtaskforcodeseek.entities.Team;
import com.testtaskforcodeseek.mappers.PlayerMapper;
import com.testtaskforcodeseek.repositories.PlayerRepository;
import com.testtaskforcodeseek.repositories.TeamRepository;
import com.testtaskforcodeseek.services.PlayersCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayersCrudServiceImpl implements PlayersCrudService {
    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;
    private final TeamRepository teamRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<GetPlayerDto> getPlayers(Pageable pageable) {
        return playerRepository.findAll(pageable).map(playerMapper::entityToDto);
    }

    @Override
    @Transactional
    public GetPlayerDto postPlayer(PostPlayerDto postPlayerDTO) {
        if (postPlayerDTO.team().id() != null) {
            Team team = teamRepository.findById(postPlayerDTO.team().id())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Team with this id doesn't exist"));
            Player player = playerMapper.dtoToEntity(postPlayerDTO);
            player.setTeam(team);
            player = playerRepository.save(player);
            return playerMapper.entityToDto(player);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Team with this id doesn't exist");
        }
    }

    @Override
    @Transactional
    public void patchPlayer(PatchPlayerDto patchPlayerDto) {
        Player player = playerRepository.findById(patchPlayerDto.id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Team with this id don't exists"));
        playerMapper.updateEntityFromDto(patchPlayerDto, player);
    }

    @Override
    @Transactional(readOnly = true)
    public GetPlayerDto getPlayer(UUID id) {
        return playerMapper.entityToDto(playerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Player with this id don't exists")));
    }

    @Override
    @Transactional
    public void deletePlayer(UUID id) {
        playerRepository.deleteById(id);
    }
}