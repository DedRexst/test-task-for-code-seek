package com.testtaskforcodeseek.dtos.requests;

import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public record PostPlayerDto(
        @Size(message = "First name must be between 2 and 50 characters long", min = 2, max = 50) @NotBlank(message = "First name can't be blank") String firstName,
        @Size(message = "Last name must be between 2 and 50 characters long", min = 2, max = 50) @NotBlank(message = "Last name can't be blank") String lastName,
        @Max(message = "Experience can't be more than 40 years.", value = 40) @PositiveOrZero(message = "Experience might be only positive or zero")
        int experience,
        TeamDto team,
        @NotNull(message = "Birthdate can't be null")
        LocalDateTime birthdate) implements Serializable {
    public record TeamDto(@NotNull(message = "Id can't be null") UUID id) implements Serializable {
    }
}