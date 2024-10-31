package com.wora.itlens.services.impl;

import com.wora.itlens.exceptions.EntityNotFoundException;
import com.wora.itlens.mappers.SurveyMapper;
import com.wora.itlens.models.dtos.surveys.CreateSurveyDto;
import com.wora.itlens.models.dtos.surveys.SurveyDto;
import com.wora.itlens.models.dtos.surveys.UpdateSurveyDto;
import com.wora.itlens.models.entites.Owner;
import com.wora.itlens.models.entites.Survey;
import com.wora.itlens.repositories.OwnerRepository;
import com.wora.itlens.repositories.SurveyRepository;
import com.wora.itlens.services.interfaces.ISurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SurveyService implements ISurveyService {

    private final SurveyRepository surveyRepository;
    private final SurveyMapper surveyMapper;
    private final OwnerRepository ownerRepository;

    @Override
    public SurveyDto save(CreateSurveyDto createSurveyDto) {
        Long ownerId = createSurveyDto.ownerId();
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new EntityNotFoundException("Owner", ownerId));

        Survey survey = surveyMapper.toEntity(createSurveyDto);
        survey.setOwner(owner);
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
        Survey survey = surveyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Survey", id));

        survey.setTitle(updateSurveyDto.title());
        survey.setDescription(updateSurveyDto.description());
        Survey updatedSurvey = surveyRepository.save(survey);
        return surveyMapper.toDto(updatedSurvey);
    }

    @Override
    public List<SurveyDto> findAll() {
        return surveyRepository.findAll().stream()
                .map(surveyMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        Survey survey = surveyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Survey", id));

        surveyRepository.delete(survey);
    }
}
