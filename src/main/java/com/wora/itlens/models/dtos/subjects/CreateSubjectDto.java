package com.wora.itlens.models.dtos.subjects;

import com.wora.itlens.annotations.Exists;
import com.wora.itlens.models.entites.Subject;
import com.wora.itlens.models.entites.SurveyEdition;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CreateSubjectDto(
        @NotBlank String title,
        @Positive @Exists(entity = SurveyEdition.class, message = "Survey Edition does not Exist") Long surveyEditionId,
        @Positive @Exists(entity = Subject.class, message = "Subject does not Exist") Long subjectId
) {
}
