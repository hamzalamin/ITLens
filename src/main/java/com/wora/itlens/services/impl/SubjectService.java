package com.wora.itlens.services.impl;

import com.wora.itlens.exceptions.EntityNotFoundException;
import com.wora.itlens.mappers.SubjectMapper;
import com.wora.itlens.mappers.SurveyEditionMapper;
import com.wora.itlens.models.dtos.subjects.CreateSubjectDto;
import com.wora.itlens.models.dtos.subjects.SubjectDto;
import com.wora.itlens.models.dtos.subjects.UpdateSubjectDto;
import com.wora.itlens.models.dtos.surveyEditions.SurveyEditionDto;
import com.wora.itlens.models.entites.Subject;
import com.wora.itlens.models.entites.SurveyEdition;
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

    @Override
    public SubjectDto save(CreateSubjectDto createSubjectDto) {
            Subject subject = new Subject();
            subject.setTitle(createSubjectDto.title());

            SurveyEdition surveyEdition = surveyEditionService.getSurveyEditionEntity(createSubjectDto.surveyEditionId());
            subject.setSurveyEdition(surveyEdition);
            if (createSubjectDto.subjectId() != null) {
                Subject parentSubject = subjectRepository.findById(createSubjectDto.subjectId())
                        .orElseThrow(() -> new EntityNotFoundException("Parent Subject", createSubjectDto.subjectId()));
                subject.setSubject(parentSubject);
            }
            Subject savedSubject = subjectRepository.save(subject);
            return subjectMapper.toDto(savedSubject);
    }



    @Override
    public SubjectDto findById(Long id) {
        Subject parentSubject = subjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subject", id));
        return subjectMapper.toDto(parentSubject);
    }

    @Override
    public SubjectDto update(UpdateSubjectDto updateSubjectDto, Long id) {
        Subject parentSubject = subjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subject", id));

        parentSubject.setTitle(updateSubjectDto.title());
        return subjectMapper.toDto(parentSubject);
    }

    @Override
    public List<SubjectDto> findAll() {
        return subjectRepository.findAll().stream()
                .map(subjectMapper::toDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subject", id));
        subjectRepository.delete(subject);
    }


    @Override
    public Subject getSubjectEntity(Long id) {
        Subject subjectEntity = subjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subject", id));;
        return subjectEntity;
    }
}
