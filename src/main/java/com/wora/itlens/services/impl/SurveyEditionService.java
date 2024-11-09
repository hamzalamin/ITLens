package com.wora.itlens.services.impl;

import com.wora.itlens.exceptions.EntityNotFoundException;
import com.wora.itlens.exceptions.InvalidSurveyDatesException;
import com.wora.itlens.mappers.SurveyEditionMapper;
import com.wora.itlens.mappers.SurveyMapper;
import com.wora.itlens.models.dtos.surveyEditions.CreateSurveyEditionDto;
import com.wora.itlens.models.dtos.surveyEditions.SurveyEditionDto;
import com.wora.itlens.models.dtos.surveyEditions.SurveyEditionStatisticDto;
import com.wora.itlens.models.dtos.surveyEditions.UpdateSurveyEditionDto;
import com.wora.itlens.models.dtos.surveys.SurveyDto;
import com.wora.itlens.models.entites.Subject;
import com.wora.itlens.models.entites.SurveyEdition;
import com.wora.itlens.repositories.SurveyEditionRepository;
import com.wora.itlens.services.interfaces.ISurveyEditionService;
import com.wora.itlens.services.interfaces.ISurveyEditionSubjectService;
import com.wora.itlens.services.interfaces.ISurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SurveyEditionService implements ISurveyEditionService {

    private final SurveyEditionRepository surveyEditionRepository;
    private final ISurveyService surveyService;
    private final SurveyEditionMapper surveyEditionMapper;
    private final SurveyMapper surveyMapper;
    private final ISurveyEditionSubjectService surveyEditionSubjectService;

    @Override
    public SurveyEditionDto save(CreateSurveyEditionDto createSurveyEditionDto) {
        Long surveyId = createSurveyEditionDto.surveyId();
        SurveyDto survey = surveyService.findById(surveyId);
        if (survey == null) {
            throw new EntityNotFoundException("Survey", surveyId);
        }
        SurveyEdition surveyEdition = surveyEditionMapper.toEntity(createSurveyEditionDto);
        surveyEdition.setCreationDate(createSurveyEditionDto.creationDate());
        surveyEdition.setStartDate(createSurveyEditionDto.startDate());
        if (surveyEdition.getStartDate().isBefore(surveyEdition.getCreationDate())) {
            throw new InvalidSurveyDatesException("Start date cannot be before the creation date.");
        }
        surveyEdition.setSurvey(surveyMapper.toEntity(survey));
        SurveyEdition savedSE = surveyEditionRepository.save(surveyEdition);
        return surveyEditionMapper.toDto(savedSE);
    }

    @Override
    public SurveyEditionDto findById(Long id) {
        SurveyEdition surveyEdition = surveyEditionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Survey Edition", id));
        return surveyEditionMapper.toDto(surveyEdition);
    }

    @Override
    public SurveyEditionDto update(UpdateSurveyEditionDto updateSurveyEditionDto, Long id) {
        SurveyEdition surveyEdition = surveyEditionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Survey Edition", id));
        Long surveyId = updateSurveyEditionDto.surveyId();
        SurveyDto survey = surveyService.findById(surveyId);
        if (survey == null) {
            throw new EntityNotFoundException("Survey", surveyId);
        }

        surveyEdition.setCreationDate(updateSurveyEditionDto.creationDate());
        surveyEdition.setStartDate(updateSurveyEditionDto.startDate());
        surveyEdition.setDate(updateSurveyEditionDto.date());
        if (surveyEdition.getStartDate().isBefore(surveyEdition.getCreationDate())) {
            throw new InvalidSurveyDatesException("Start date cannot be before the creation date.");
        }
        surveyEdition.setSurvey(surveyMapper.toEntity(survey));
        SurveyEdition updatedSurveyEd = surveyEditionRepository.save(surveyEdition);
        return surveyEditionMapper.toDto(updatedSurveyEd);
    }

    @Override
    public List<SurveyEditionDto> findAll() {
        List<SurveyEditionDto> surveyDtoList = surveyEditionRepository.findAll().stream()
                .map(surveyEditionMapper::toDto)
                .toList();
        return surveyDtoList;
    }

    @Override
    public void delete(Long id) {
        SurveyEdition surveyEdition = surveyEditionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Survey Edition", id));
        surveyEditionRepository.delete(surveyEdition);
    }

    @Override
    public SurveyEdition getSurveyEditionEntity(Long id){
        return surveyEditionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Survey Edition", id));
    }

    @Override
    public SurveyEditionStatisticDto getStatistics(Long id) {
        SurveyEdition surveyEdition = surveyEditionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Survey Edition", id));

        List<Subject> subjects = surveyEditionSubjectService.getListsSubjectsBySurveyEditionId(id);

        int totalSubjects = subjects.size();

        int totalQuestions = subjects.stream()
                .mapToInt(subject -> subject.getQuestions().size())
                .sum();

        int totalAnswers = subjects.stream()
                .flatMap(subject -> subject.getQuestions().stream())
                .filter(question -> question.getAnswers() != null)
                .mapToInt(question -> question.getAnswers().size())
                .sum();

        int totalSubjectsAnswered = (int) subjects.stream()
                .filter(subject -> subject.getQuestions().stream()
                        .anyMatch(question -> question.getAnswers() != null && !question.getAnswers().isEmpty()))
                .count();


        LocalDate creationDate = surveyEdition.getCreationDate();
        LocalDate startDate = surveyEdition.getStartDate();
        int date = surveyEdition.getDate();

        double percentageAnsweredQuestions = (double) totalAnswers / totalQuestions * 100;
        double percentageAnsweredSubjects = (double) totalSubjectsAnswered / totalSubjects * 100;
        double answersPerSubjectPercentage = (double) totalAnswers / (totalSubjects * totalQuestions) * 100;

        return new SurveyEditionStatisticDto(
                creationDate,
                startDate,
                date,
                totalSubjects,
                totalQuestions,
                totalAnswers,
                percentageAnsweredQuestions,
                percentageAnsweredSubjects,
                answersPerSubjectPercentage
        );
    }


}
