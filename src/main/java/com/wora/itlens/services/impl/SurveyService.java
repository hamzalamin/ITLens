package com.wora.itlens.services.impl;

import com.wora.itlens.exceptions.EntityNotFoundException;
import com.wora.itlens.mappers.SurveyMapper;
import com.wora.itlens.models.dtos.surveys.CreateSurveyDto;
import com.wora.itlens.models.dtos.surveys.SurveyDto;
import com.wora.itlens.models.dtos.surveys.UpdateSurveyDto;
import com.wora.itlens.models.entites.Survey;
import com.wora.itlens.repositories.SurveyRepository;
import com.wora.itlens.services.interfaces.ISurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SurveyService implements ISurveyService {

    private final SurveyRepository surveyRepository;
    private final SurveyMapper surveyMapper;

    @Override
    public SurveyDto save(CreateSurveyDto createSurveyDto) {
        Survey survey = surveyMapper.toEntity(createSurveyDto);
        Survey savedSurvey = surveyRepository.save(survey);
        return surveyMapper.toDto(savedSurvey);
    }

    @Override
    public SurveyDto findById(Long id) {
        Survey survey = surveyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Survey", id));
        return surveyMapper.toDto(survey);
    }

    @Override
    public SurveyDto update(UpdateSurveyDto updateSurveyDto, Long id) {
        return null;
    }

    @Override
    public List<SurveyDto> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }
}
