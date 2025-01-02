package com.testtaskforcodeseek.dtos.responses;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


public record GetTeamDto(UUID id, String title, List<GetTeamDto.GetPlayerDto> players, double commission,
                         double funds) implements Serializable {
    public record GetPlayerDto(UUID id, String firstName, String lastName, int experience) implements Serializable {
    }
}