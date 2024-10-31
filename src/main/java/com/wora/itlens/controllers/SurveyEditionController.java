package com.wora.itlens.controllers;

import com.wora.itlens.models.dtos.surveyEditions.CreateSurveyEditionDto;
import com.wora.itlens.models.dtos.surveyEditions.SurveyEditionDto;
import com.wora.itlens.services.interfaces.ISurveyEditionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/survey/edition")
@RequiredArgsConstructor
public class SurveyEditionController {
    private final ISurveyEditionService surveyEditionService;

    @PostMapping
    public ResponseEntity<SurveyEditionDto> createSurveyEdition(@RequestBody @Valid CreateSurveyEditionDto createSurveyEditionDto){
        return new ResponseEntity<>(surveyEditionService.save(createSurveyEditionDto), HttpStatus.OK);
    }
}
