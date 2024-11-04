package com.wora.itlens.controllers;

import com.wora.itlens.models.dtos.answerResponses.AnswerResponseDto;
import com.wora.itlens.models.dtos.answerResponses.CreateMultipleAnswersAndMultipleResponsesDto;
import com.wora.itlens.models.dtos.answerResponses.CreateMultipleAnswersAndOneQuestionDto;
import com.wora.itlens.models.dtos.answerResponses.QuestionWithAnswersResponseDto;
import com.wora.itlens.services.interfaces.IAnswerResponseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
@RequiredArgsConstructor
public class AnswerResponseController {
    private final IAnswerResponseService answerResponseService;

    @PostMapping("/create-multiple")
    public ResponseEntity<List<QuestionWithAnswersResponseDto>> createAnswers(@RequestBody CreateMultipleAnswersAndOneQuestionDto dto) {
        List<QuestionWithAnswersResponseDto> createdAnswers = answerResponseService.createAnswersForQuestion(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnswers);
    }

    @PostMapping("/process")
    public ResponseEntity<?> processMultipleQuestionsAndAnswers(@RequestBody CreateMultipleAnswersAndMultipleResponsesDto dto) {
        List<Object> response = answerResponseService.processMultipleQuestionsAndAnswers(dto);
        return ResponseEntity.ok(response);
    }


}
