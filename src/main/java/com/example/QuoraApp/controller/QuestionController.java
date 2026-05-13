package com.example.QuoraApp.controller;

import com.example.QuoraApp.dto.QuestionRequestDto;
import com.example.QuoraApp.dto.QuestionResponseDto;
import com.example.QuoraApp.service.QuestionService;
import com.example.QuoraApp.util.CursorUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

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

    @GetMapping
    public Flux<QuestionResponseDto> getAllQuestions(
            @RequestParam(required = false) String cursor,
            @RequestParam(defaultValue = "10") Integer size
    ){
        return questionService.getAllQuestions(cursor, size);
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
