package com.testtaskforcodeseek.controllers;

import com.testtaskforcodeseek.dtos.requests.PatchPlayerDto;
import com.testtaskforcodeseek.dtos.requests.PostPlayerDto;
import com.testtaskforcodeseek.dtos.responses.GetPlayerDto;
import com.testtaskforcodeseek.services.PlayersCrudService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/players")
@RequiredArgsConstructor
public class PlayersCrudController {
    private final PlayersCrudService playersCrudService;

    @GetMapping
    public Page<GetPlayerDto> getPlayers(Pageable pageable){
        return playersCrudService.getPlayers(pageable);
    }

    @GetMapping("/by-id")
    public GetPlayerDto getPlayer(@PathParam("id") UUID id){
        return playersCrudService.getPlayer(id);
    }

    @PostMapping
    public GetPlayerDto postPlayer(@RequestBody @Valid PostPlayerDto postPlayerDto){
        return playersCrudService.postPlayer(postPlayerDto);
    }

    @PatchMapping
    public void patchPlayer(@RequestBody @Valid PatchPlayerDto patchPlayerDto){
        playersCrudService.patchPlayer(patchPlayerDto);
    }

    @DeleteMapping
    public void deletePlayer(@PathParam("id") UUID id) {
        playersCrudService.deletePlayer(id);
    }
}
