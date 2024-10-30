package com.wora.itlens.models.dtos.owners;

import jakarta.validation.constraints.NotBlank;

public record CreateOwnerDto(
        @NotBlank String name
){
}
