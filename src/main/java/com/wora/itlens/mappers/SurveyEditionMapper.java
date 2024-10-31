package com.wora.itlens.mappers;

import com.wora.itlens.mappers.api.GenericMapper;
import com.wora.itlens.models.dtos.surveyEditions.CreateSurveyEditionDto;
import com.wora.itlens.models.dtos.surveyEditions.SurveyEditionDto;
import com.wora.itlens.models.dtos.surveyEditions.UpdateSurveyEditionDto;
import com.wora.itlens.models.dtos.surveys.SurveyDto;
import com.wora.itlens.models.entites.Survey;
import com.wora.itlens.models.entites.SurveyEdition;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SurveyEditionMapper extends GenericMapper<SurveyEditionDto, SurveyEdition> {
    SurveyEdition toEntity(CreateSurveyEditionDto createSurveyEditionDto);
    SurveyEdition toEntity(UpdateSurveyEditionDto updateSurveyEditionDto);
    SurveyEdition toEntity(SurveyEditionDto surveyEditionDto);
    SurveyEditionDto toDto(SurveyEdition surveyEdition);
}
