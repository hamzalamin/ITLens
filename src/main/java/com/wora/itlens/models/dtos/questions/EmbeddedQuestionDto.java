package com.wora.itlens.models.dtos.questions;

import com.wora.itlens.models.dtos.answers.EmbeddedAnswerDto;
import com.wora.itlens.models.enumes.QuestionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;


public record EmbeddedQuestionDto(
        @NotNull @Positive Long id,
        @NotBlank String text,
        @NotNull @Positive Integer answerCount,
        @NotNull QuestionType questionType,
        List<EmbeddedAnswerDto> answers
) {
}
