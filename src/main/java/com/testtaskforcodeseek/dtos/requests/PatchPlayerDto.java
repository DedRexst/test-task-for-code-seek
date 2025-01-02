package com.testtaskforcodeseek.dtos.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public record PatchPlayerDto(
        @NotNull(message = "Id can't be null")
        UUID id,
        @Size(message = "First name must be between 2 and 50 characters long", min = 2, max = 50) String firstName,
        @Size(message = "Last name must be between 2 and 50 characters long", min = 2, max = 50) String lastName,
        @Max(message = "Experience can't be more than 40 years.", value = 40)
        @PositiveOrZero(message = "Experience might be only positive or zero")
        int experience,
        @NotNull(message = "Birthdate can't be null")
        LocalDateTime birthdate) implements Serializable {
}