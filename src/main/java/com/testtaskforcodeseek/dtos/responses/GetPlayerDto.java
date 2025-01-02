package com.testtaskforcodeseek.dtos.responses;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public record GetPlayerDto(
        UUID id, String firstName,
        String lastName,
        int experience,
        GetTeamDto team,
        LocalDateTime birthdate) implements Serializable {
    public record GetTeamDto(UUID id,
                             @Size(message = "Title must be between 2 and 50 characters long", min = 2, max = 50)
                             @NotBlank(message = "Title can't be blank")
                             String title,
                             @Max(message = "Commission can't be more than 10%", value = 10)
                             @PositiveOrZero(message = "Commission can't be less than zero")
                             double commission

    ) implements Serializable {
    }
}