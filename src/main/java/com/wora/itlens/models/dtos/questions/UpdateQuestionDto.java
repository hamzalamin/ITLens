package com.wora.itlens.models.dtos.questions;

import com.wora.itlens.annotations.Exists;
import com.wora.itlens.models.entites.Subject;
import com.wora.itlens.models.enumes.QuestionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UpdateQuestionDto(
        @NotBlank String text,
        @NotNull QuestionType questionType,
        @NotNull @Positive @Exists(entity = Subject.class) Long subjectId
) {
}
