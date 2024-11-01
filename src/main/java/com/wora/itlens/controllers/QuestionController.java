package com.wora.itlens.controllers;


import com.wora.itlens.models.dtos.questions.CreateQuestionDto;
import com.wora.itlens.models.dtos.questions.QuestionsDto;
import com.wora.itlens.models.dtos.questions.UpdateQuestionDto;
import com.wora.itlens.services.interfaces.IQuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final IQuestionService questionService;

    @PostMapping
    public ResponseEntity<QuestionsDto> createQuestion(@RequestBody @Valid CreateQuestionDto createQuestionDto){
        return new ResponseEntity<>(questionService.save(createQuestionDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<QuestionsDto>> findAll(){
        List<QuestionsDto> questionsDtoList = questionService.findAll();
        return new ResponseEntity<>(questionsDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionsDto> findById(@PathVariable Long id){
        QuestionsDto question = questionService.findById(id);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionsDto> updateQuestion(
            @PathVariable Long id,
            @RequestBody @Valid UpdateQuestionDto updateQuestionDto
    ){
        return new ResponseEntity<>(questionService.update(updateQuestionDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        questionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
