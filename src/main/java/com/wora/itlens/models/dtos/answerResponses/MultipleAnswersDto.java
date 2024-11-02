package com.wora.itlens.models.dtos.answerResponses;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.List;

public record MultipleAnswersDto(
        @NotNull @Positive Long questionId,
        @Size(min = 1)List<@Positive @NotNull Long> answers
){
}
