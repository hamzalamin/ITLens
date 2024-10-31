package com.wora.itlens.services.impl;

import com.wora.itlens.exceptions.EntityNotFoundException;
import com.wora.itlens.mappers.SubjectMapper;
import com.wora.itlens.mappers.SurveyEditionMapper;
import com.wora.itlens.models.dtos.subjects.CreateSubjectDto;
import com.wora.itlens.models.dtos.subjects.SubjectDto;
import com.wora.itlens.models.dtos.subjects.UpdateSubjectDto;
import com.wora.itlens.models.dtos.surveyEditions.SurveyEditionDto;
import com.wora.itlens.models.entites.Subject;
import com.wora.itlens.repositories.SubjectRepository;
import com.wora.itlens.services.interfaces.ISubjectService;
import com.wora.itlens.services.interfaces.ISurveyEditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService implements ISubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;
    private final ISurveyEditionService surveyEditionService;
    private final SurveyEditionMapper surveyEditionMapper;

    @Override
    public SubjectDto saveSubject(Long surveyEditionId, CreateSubjectDto createSubjectDto) {
        SurveyEditionDto surveyEdition = surveyEditionService.findById(surveyEditionId);
        if (surveyEdition == null) {
            throw new EntityNotFoundException("Survey Edition", surveyEditionId);
        }
        Subject subject = subjectMapper.toEntity(createSubjectDto);
        subject.setSurveyEdition(surveyEditionMapper.toEntity(surveyEdition));
        Subject savedSubject = subjectRepository.save(subject);
        return subjectMapper.toDto(savedSubject);
    }


    @Override
    public SubjectDto save(CreateSubjectDto createSubjectDto) {
        throw new UnsupportedOperationException();
    }

    @Override
    public SubjectDto findById(Long id) {
        return null;
    }

    @Override
    public SubjectDto update(UpdateSubjectDto updateSubjectDto, Long id) {
        return null;
    }

    @Override
    public List<SubjectDto> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }
}
