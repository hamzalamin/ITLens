package com.wora.itlens.services.impl;

import com.wora.itlens.mappers.SurveyMapper;
import com.wora.itlens.models.dtos.surveys.CreateSurveyDto;
import com.wora.itlens.models.dtos.surveys.SurveyDto;
import com.wora.itlens.models.dtos.surveys.UpdateSurveyDto;
import com.wora.itlens.repositories.SurveyRepository;
import com.wora.itlens.services.interfaces.ISurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyService implements ISurveyService {

    private final SurveyRepository surveyRepository;
    private final SurveyMapper surveyMapper;

    @Override
    public SurveyDto save(CreateSurveyDto createSurveyDto) {
        return null;
    }

    @Override
    public SurveyDto findById(Long aLong) {
        return null;
    }

    @Override
    public SurveyDto update(UpdateSurveyDto updateSurveyDto, Long aLong) {
        return null;
    }

    @Override
    public List<SurveyDto> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long aLong) {

    }
}
