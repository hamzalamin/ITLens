package com.wora.itlens.services.impl;

import com.wora.itlens.exceptions.EntityNotFoundException;
import com.wora.itlens.mappers.SurveyEditionMapper;
import com.wora.itlens.mappers.SurveyMapper;
import com.wora.itlens.models.dtos.surveyEditions.CreateSurveyEditionDto;
import com.wora.itlens.models.dtos.surveyEditions.SurveyEditionDto;
import com.wora.itlens.models.dtos.surveyEditions.UpdateSurveyEditionDto;
import com.wora.itlens.models.dtos.surveys.SurveyDto;
import com.wora.itlens.models.entites.SurveyEdition;
import com.wora.itlens.repositories.SurveyEditionRepository;
import com.wora.itlens.services.interfaces.ISurveyEditionService;
import com.wora.itlens.services.interfaces.ISurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyEditionService implements ISurveyEditionService {

    private final SurveyEditionRepository surveyEditionRepository;
    private final ISurveyService surveyService;
    private final SurveyEditionMapper surveyEditionMapper;
    private final SurveyMapper surveyMapper;

    @Override
    public SurveyEditionDto save(CreateSurveyEditionDto createSurveyEditionDto) {
        Long surveyId = createSurveyEditionDto.surveyId();
        SurveyDto survey = surveyService.findById(surveyId);
        if (survey == null) {
            throw new EntityNotFoundException("Survey", surveyId);
        }
        SurveyEdition surveyEdition = surveyEditionMapper.toEntity(createSurveyEditionDto);
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
        return null;
    }

    @Override
    public List<SurveyEditionDto> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }
}
