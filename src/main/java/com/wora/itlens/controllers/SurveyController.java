package com.wora.itlens.controllers;

import com.wora.itlens.models.dtos.surveys.CreateSurveyDto;
import com.wora.itlens.models.dtos.surveys.SurveyDto;
import com.wora.itlens.models.dtos.surveys.UpdateSurveyDto;
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

    @GetMapping("/{id}")
    public ResponseEntity<SurveyDto> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(surveyService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SurveyDto> updateSurvey(
            @PathVariable("id") Long id,
            @RequestBody @Valid UpdateSurveyDto updateSurveyDto) {
        return new ResponseEntity<>(surveyService.update(updateSurveyDto, id), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Long id){
        surveyService.delete(id);
        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
