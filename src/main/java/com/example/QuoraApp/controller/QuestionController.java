package com.example.QuoraApp.controller;

import com.example.QuoraApp.dto.QuestionRequestDto;
import com.example.QuoraApp.dto.QuestionResponseDto;
import com.example.QuoraApp.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping
    public Mono<QuestionResponseDto> createQuestion(@RequestBody QuestionRequestDto requestDto){
        return questionService.createQuestion(requestDto)
                .doOnSuccess(response -> System.out.println("Question created successfully"))
                .doOnError(error -> System.out.println("Error creating question: " + error));
    }

    @GetMapping("/search")
    public Flux<QuestionResponseDto> searchQuestions(
            @RequestParam String searchTerm,
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "10") int page
    ){
        return questionService.searchQuestions(searchTerm, offset, page);
    }
}
