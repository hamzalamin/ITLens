package com.wora.itlens.controllers;

import com.wora.itlens.models.dtos.surveyEditions.CreateSurveyEditionDto;
import com.wora.itlens.models.dtos.surveyEditions.SurveyEditionDto;
import com.wora.itlens.models.dtos.surveyEditions.UpdateSurveyEditionDto;
import com.wora.itlens.services.interfaces.ISurveyEditionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/survey/edition")
@RequiredArgsConstructor
public class SurveyEditionController {
    private final ISurveyEditionService surveyEditionService;

    @PostMapping
    public ResponseEntity<SurveyEditionDto> createSurveyEdition(@RequestBody @Valid CreateSurveyEditionDto createSurveyEditionDto){
        return new ResponseEntity<>(surveyEditionService.save(createSurveyEditionDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SurveyEditionDto>> findAllSurveyEditions(){
        List<SurveyEditionDto> surveyEditionDtoList = surveyEditionService.findAll();
        return new ResponseEntity<>(surveyEditionDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurveyEditionDto> findById(@PathVariable Long id){
        return new ResponseEntity<>(surveyEditionService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SurveyEditionDto> updateSurveyEdition(
            @PathVariable Long id,
            @RequestBody UpdateSurveyEditionDto updateSurveyEditionDto
    ){
        return new ResponseEntity<>(surveyEditionService.update(updateSurveyEditionDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurveyEdition(@PathVariable Long id){
        surveyEditionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
