package com.wora.itlens.controllers;

import com.wora.itlens.models.dtos.answerResponses.*;
import com.wora.itlens.services.interfaces.IAnswerResponseService;
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

    @PostMapping("/process-multiple")
    public ResponseEntity<List<QuestionWithAnswersResponseDto>> processMultipleQuestionsAndAnswers(@RequestBody CreateMultipleAnswersAndMultipleResponsesDto dto) {
        List<QuestionWithAnswersResponseDto> response = answerResponseService.processMultipleQuestionsAndAnswers(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/response")
    public ResponseEntity<AnswerResponseDto> saveAnswerResponse(@RequestBody CreateAnswerResponseDto createAnswerResponseDto) {
        return new ResponseEntity<>(answerResponseService.saveUserAnswer(createAnswerResponseDto.answerId(), createAnswerResponseDto.questionId()), HttpStatus.OK);
    }

    @PostMapping("/handleAll")
    public ResponseEntity<?> handleAll(@RequestBody GeneralRequestDto generalRequestDto) {
        System.out.println("dto li feha kouulchi " + generalRequestDto);

        try {
            CreateAnswerResponseDto createAnswerResponseDto = generalRequestDto.createAnswerResponseDto();
            CreateMultipleAnswersAndMultipleResponsesDto createMultipleAnswersAndMultipleResponsesDto = generalRequestDto.createMultipleAnswersAndMultipleResponsesDto();
            CreateMultipleAnswersAndOneQuestionDto createMultipleAnswersAndOneQuestionDto = generalRequestDto.createMultipleAnswersAndOneQuestionDto();

            if (createAnswerResponseDto != null) {
                answerResponseService.saveUserAnswer(createAnswerResponseDto.answerId(), createAnswerResponseDto.questionId());
            }
            if (createMultipleAnswersAndMultipleResponsesDto != null) {
                answerResponseService.processMultipleQuestionsAndAnswers(createMultipleAnswersAndMultipleResponsesDto);
                System.out.println("normalment hani dwwwit 2");

            }
            if (createMultipleAnswersAndOneQuestionDto != null) {
                answerResponseService.createAnswersForQuestion(createMultipleAnswersAndOneQuestionDto);
                System.out.println("normalment hani dwwwit 3");

            }

            return ResponseEntity.ok("CREATED SUCCESSFULLY");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request");
        }
    }

}
