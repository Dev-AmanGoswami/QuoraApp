package com.example.QuoraApp.service;

import com.example.QuoraApp.dto.QuestionRequestDto;
import com.example.QuoraApp.dto.QuestionResponseDto;
import com.example.QuoraApp.model.Question;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IQuestionService {
    Mono<QuestionResponseDto> createQuestion(QuestionRequestDto requestDto);

    Flux<QuestionResponseDto> getAllQuestions(String cursor, int size);

    Flux<QuestionResponseDto> searchQuestions(String searchTerm, int offset, int page);
}
