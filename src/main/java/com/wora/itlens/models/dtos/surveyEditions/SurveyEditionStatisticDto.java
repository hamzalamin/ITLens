package com.wora.itlens.models.dtos.surveyEditions;

import java.time.LocalDate;

public record SurveyEditionStatisticDto(
        LocalDate creationDate,
        LocalDate startDate,
        LocalDate date,
        int totalParticipantCount,
        int totalQuestionCount,
        int totalAnswerCount
) {
}
