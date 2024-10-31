package com.wora.itlens.controllers;

import com.wora.itlens.services.interfaces.ISurveyEditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/survey/edition")
@RequiredArgsConstructor
public class SurveyEditionController {
    private final ISurveyEditionService surveyEditionService;

}
