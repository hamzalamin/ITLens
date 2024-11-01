package com.wora.itlens.services.interfaces;

import com.wora.itlens.models.dtos.answers.AnswerDto;
import com.wora.itlens.models.dtos.answers.CreateAnswerDto;
import com.wora.itlens.models.dtos.answers.UpdateAnswerDto;
import com.wora.itlens.services.GenericService;

public interface IAnswerService extends GenericService<CreateAnswerDto, UpdateAnswerDto, AnswerDto, Long> {
}
