package com.wora.itlens.services.impl;

import com.wora.itlens.models.entites.Subject;
import com.wora.itlens.repositories.SubjectRepository;
import com.wora.itlens.services.interfaces.ISurveyEditionSubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyEditionSubjectService implements ISurveyEditionSubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    public List<Subject> getListsSubjectsBySurveyEditionId(Long surveyEditionId) {
        return subjectRepository.findAllBySurveyEditionId(surveyEditionId);
    }
}
