package com.wora.itlens.controllers;

import com.wora.itlens.models.dtos.subjects.CreateSubjectDto;
import com.wora.itlens.models.dtos.subjects.SubjectDto;
import com.wora.itlens.services.interfaces.ISubSubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class SubSubjectController {

    private final ISubSubjectService subSubjectService;

    @PostMapping("/chapters/{subjectId}/subchapters")
    private ResponseEntity<SubjectDto> createSubSubject(
            @PathVariable Long subjectId,
            @RequestBody CreateSubjectDto createSubjectDto)
    {
        return new ResponseEntity<>(subSubjectService.savedSubSubject(subjectId, createSubjectDto), HttpStatus.OK);
    }

}
