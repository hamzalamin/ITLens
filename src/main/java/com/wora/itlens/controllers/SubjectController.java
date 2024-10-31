package com.wora.itlens.controllers;

import com.wora.itlens.models.dtos.subjects.CreateSubjectDto;
import com.wora.itlens.models.dtos.subjects.SubjectDto;
import com.wora.itlens.services.impl.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping("/surveys/{surveyEditionId}/subjects")
    public ResponseEntity<SubjectDto> createSubject(
            @PathVariable Long surveyEditionId,
            @RequestBody CreateSubjectDto createSubjectDto
    ){
        return new ResponseEntity<>(subjectService.saveSubject(surveyEditionId, createSubjectDto), HttpStatus.OK);
    }

}
