package com.wora.itlens.models.dtos.owners;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record EmbeddedOwnerDto(
        @NotNull @Positive Long id,
        @NotBlank String name
) {
}
