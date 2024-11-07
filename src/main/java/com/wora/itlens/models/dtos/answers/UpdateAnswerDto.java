package com.wora.itlens.models.dtos.answers;

import com.wora.itlens.annotations.Exists;
import com.wora.itlens.models.entites.Question;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UpdateAnswerDto(
        @NotBlank String text,
        @Positive @NotNull @Exists(entity = Question.class) Long questionId

) {
}
