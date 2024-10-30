package com.wora.itlens.models.dtos.owners;

import jakarta.validation.constraints.NotBlank;

public record UpdateOwnerDto(
        @NotBlank String name
) {
}
