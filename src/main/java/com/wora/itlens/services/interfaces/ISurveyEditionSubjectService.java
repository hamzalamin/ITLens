package com.wora.itlens.services.interfaces;

import com.wora.itlens.models.entites.Subject;

import java.util.List;

public interface ISurveyEditionSubjectService {
    List<Subject> getListsSubjectsBySurveyEditionId(Long surveyEditionId);
}
