package com.wora.itlens.services.interfaces;

import com.wora.itlens.models.dtos.surveyEditions.CreateSurveyEditionDto;
import com.wora.itlens.models.dtos.surveyEditions.SurveyEditionDto;
import com.wora.itlens.models.dtos.surveyEditions.UpdateSurveyEditionDto;
import com.wora.itlens.models.entites.SurveyEdition;
import com.wora.itlens.services.GenericService;

public interface ISurveyEditionService extends GenericService<CreateSurveyEditionDto, UpdateSurveyEditionDto, SurveyEditionDto, Long> {
    SurveyEdition getSurveyEditionEntity(Long id);

}
