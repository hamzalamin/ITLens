package com.wora.itlens.models.dtos.subjects;

import jakarta.validation.constraints.NotBlank;

public record UpdateSubjectDto(
        @NotBlank String title
) {
}
