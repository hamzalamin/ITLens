package com.wora.itlens.services.impl;

import com.wora.itlens.mappers.SurveyEditionMapper;
import com.wora.itlens.models.dtos.surveyEditions.CreateSurveyEditionDto;
import com.wora.itlens.models.dtos.surveyEditions.SurveyEditionDto;
import com.wora.itlens.models.dtos.surveyEditions.UpdateSurveyEditionDto;
import com.wora.itlens.repositories.SurveyEditionRepository;
import com.wora.itlens.services.interfaces.ISurveyEditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyEditionService implements ISurveyEditionService {

    private final SurveyEditionRepository surveyEditionRepository;
    private final SurveyEditionMapper surveyEditionMapper;

    @Override
    public SurveyEditionDto save(CreateSurveyEditionDto createSurveyEditionDto) {
        return null;
    }

    @Override
    public SurveyEditionDto findById(Long aLong) {
        return null;
    }

    @Override
    public SurveyEditionDto update(UpdateSurveyEditionDto updateSurveyEditionDto, Long aLong) {
        return null;
    }

    @Override
    public List<SurveyEditionDto> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long aLong) {

    }
}
