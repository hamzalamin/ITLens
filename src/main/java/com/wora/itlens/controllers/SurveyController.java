package com.wora.itlens.controllers;

import com.wora.itlens.mappers.SurveyMapper;
import com.wora.itlens.models.dtos.surveys.CreateSurveyDto;
import com.wora.itlens.models.dtos.surveys.SurveyDto;
import com.wora.itlens.services.impl.SurveyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/surveys")
@RequiredArgsConstructor
public class SurveyController {

    private final SurveyService surveyService;

    @PostMapping
    public ResponseEntity<SurveyDto> createSurvey(@RequestBody @Valid CreateSurveyDto createSurveyDto){
        return new ResponseEntity<>(surveyService.save(createSurveyDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SurveyDto>> findAllSurveys(){
        List<SurveyDto> surveyDtoList = surveyService.findAll();
        return new ResponseEntity<>(surveyDtoList, HttpStatus.OK);
    }

}
