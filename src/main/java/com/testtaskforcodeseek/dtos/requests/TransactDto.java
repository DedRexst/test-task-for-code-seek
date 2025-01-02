package com.testtaskforcodeseek.dtos.requests;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record TransactDto(@NotNull(message = "Player can't be null") UUID player,
                          @NotNull(message = "Buyer can't be null") UUID buyer) {
}
