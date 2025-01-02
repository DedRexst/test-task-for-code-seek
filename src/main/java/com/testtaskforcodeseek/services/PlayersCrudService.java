package com.testtaskforcodeseek.services;

import com.testtaskforcodeseek.dtos.requests.PatchPlayerDto;
import com.testtaskforcodeseek.dtos.requests.PostPlayerDto;
import com.testtaskforcodeseek.dtos.responses.GetPlayerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PlayersCrudService {

    Page<GetPlayerDto> getPlayers(Pageable pageable);

    GetPlayerDto postPlayer(PostPlayerDto postPlayerDTO);

    void patchPlayer(PatchPlayerDto patchPlayerDto);

    GetPlayerDto getPlayer(UUID id);

    void deletePlayer(UUID id);
}
