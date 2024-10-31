package com.wora.itlens.mappers;

import com.wora.itlens.mappers.api.GenericMapper;
import com.wora.itlens.models.dtos.surveys.CreateSurveyDto;
import com.wora.itlens.models.dtos.surveys.SurveyDto;
import com.wora.itlens.models.dtos.surveys.UpdateSurveyDto;
import com.wora.itlens.models.entites.Survey;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SurveyMapper extends GenericMapper<Survey, SurveyDto> {
    Survey toEntity(CreateSurveyDto createSurveyDto);
    Survey toEntity(UpdateSurveyDto updateSurveyDto);
    Survey toEntity(SurveyDto surveyDto);
    SurveyDto toDto(Survey survey);
}
