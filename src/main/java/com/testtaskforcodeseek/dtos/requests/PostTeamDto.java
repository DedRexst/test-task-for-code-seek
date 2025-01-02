package com.testtaskforcodeseek.dtos.requests;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record PostTeamDto(
        @Size(message = "Title must be between 2 and 50 characters long", min = 2, max = 50)
        @NotBlank(message = "Title can't be blank")
        String title,
        @DecimalMax(value = "10.0", message = "Commission can't be more than 10%.")
        @PositiveOrZero(message = "Commission might be only positive or zero")
        double commission) implements Serializable {
}