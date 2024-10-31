package com.wora.itlens.controllers;

import com.wora.itlens.models.dtos.subjects.CreateSubjectDto;
import com.wora.itlens.models.dtos.subjects.SubjectDto;
import com.wora.itlens.models.dtos.subjects.UpdateSubjectDto;
import com.wora.itlens.services.interfaces.ISubSubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/chapters/{id}")
    public ResponseEntity<SubjectDto> updateSubject(
            @PathVariable Long id,
            @RequestBody UpdateSubjectDto updateSubjectDto
    ){
        return new ResponseEntity<>(subSubjectService.update(updateSubjectDto, id), HttpStatus.OK);
    }

    @GetMapping("/chapters/{id}")
    public ResponseEntity<SubjectDto> findById(@PathVariable Long id){
        return new ResponseEntity<>(subSubjectService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/chapters")
    public ResponseEntity<List<SubjectDto>> findAll(){
        List<SubjectDto> subjectDtoList = subSubjectService.findAll();
        return new ResponseEntity<>(subjectDtoList, HttpStatus.OK);
    }

    @DeleteMapping("/chapters/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        subSubjectService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
