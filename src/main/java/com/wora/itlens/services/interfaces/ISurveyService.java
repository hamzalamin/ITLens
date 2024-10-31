package com.wora.itlens.services.interfaces;

import com.wora.itlens.models.dtos.surveys.CreateSurveyDto;
import com.wora.itlens.models.dtos.surveys.SurveyDto;
import com.wora.itlens.models.dtos.surveys.UpdateSurveyDto;
import com.wora.itlens.services.GenericService;

public interface ISurveyService extends GenericService<CreateSurveyDto, UpdateSurveyDto, SurveyDto, Long> {
}
