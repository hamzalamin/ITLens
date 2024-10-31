package com.wora.itlens.models.dtos.subjects;

import jakarta.validation.constraints.NotBlank;

public record CreateSubjectDto(
        @NotBlank String title
) {
}
