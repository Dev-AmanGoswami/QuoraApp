package com.example.QuoraApp.service;

import com.example.QuoraApp.adapter.QuestionAdapter;
import com.example.QuoraApp.dto.QuestionRequestDto;
import com.example.QuoraApp.dto.QuestionResponseDto;
import com.example.QuoraApp.model.Question;
import com.example.QuoraApp.repository.QuestionRepository;
import com.example.QuoraApp.util.CursorUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class QuestionService implements IQuestionService{

    private final QuestionRepository questionRepository;

    @Override
    public Mono<QuestionResponseDto> createQuestion(QuestionRequestDto requestDto){
        Question question = Question.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return questionRepository
                .save(question)
                .map(QuestionAdapter::toQuestionResponseDto)
                .doOnSuccess(response -> System.out.println("Question created successfully"))
                .doOnError(error -> System.out.println("Error creating question: " + error));
    }

    @Override
    public Flux<QuestionResponseDto> getAllQuestions(String cursor, int size){
        Pageable pageable = PageRequest.of(0, size);
        if(!CursorUtils.isValidCursor(cursor)){
            return questionRepository
                    .findTop10ByOrderByCreatedAtAsc()
                    .take(size)
                    .map(QuestionAdapter::toQuestionResponseDto)
                    .doOnComplete(() -> System.out.println("Questions fetched successfully"))
                    .doOnError(error -> System.out.println("Error fetching questions: " + error));
        }else{
            LocalDateTime cursorTimestamp = CursorUtils.parseCursorToTime(cursor);
            return questionRepository
                    .findByCreatedAtGreaterThanOrderByCreatedAtAsc(cursorTimestamp, pageable)
                    .map(QuestionAdapter::toQuestionResponseDto)
                    .doOnComplete(() -> System.out.println("Questions fetched successfully"))
                    .doOnError(error -> System.out.println("Error fetching questions: " + error));
        }
    }

    @Override
    public Flux<QuestionResponseDto> searchQuestions(String searchTerm, int offset, int page){
        return questionRepository
                .findByTitleOrContentContainingIgnoreCase(searchTerm, PageRequest.of(offset, page))
                .map(QuestionAdapter::toQuestionResponseDto)
                .doOnComplete(() -> System.out.println("Questions searched successfully"))
                .doOnError(error -> System.out.println("Error searching questions: " + error));
    }
}
