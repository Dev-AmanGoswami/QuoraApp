package com.example.QuoraApp.service;

import com.example.QuoraApp.dto.AnswerRequestDto;
import com.example.QuoraApp.dto.AnswerResponseDto;
import com.example.QuoraApp.model.Answer;
import reactor.core.publisher.Mono;

public interface IAnswerService {
    Mono<AnswerResponseDto> createAnswer(AnswerRequestDto request);

    Mono<AnswerResponseDto> getAnswerById(String id);
}
