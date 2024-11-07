package com.wora.itlens.models.dtos.surveyEditions;

import java.time.LocalDate;

public record SurveyEditionStatisticDto(
        LocalDate creationDate,
        LocalDate startDate,
        LocalDate date,
        int totalSubjects,
        int totalQuestions,
        int totalAnswers,
        double percentageAnsweredQuestions,
        double percentageAnsweredSubjects,
        double answersPerSubjectPercentage
) {
}
