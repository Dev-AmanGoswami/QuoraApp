package com.example.QuoraApp.adapter;

import com.example.QuoraApp.dto.QuestionRequestDto;
import com.example.QuoraApp.dto.QuestionResponseDto;
import com.example.QuoraApp.model.Question;
import org.springframework.stereotype.Component;

@Component
public class QuestionAdapter {

    public static QuestionResponseDto toQuestionResponseDto(Question question){
        return QuestionResponseDto.builder()
                .id(question.getId())
                .title(question.getTitle())
                .content(question.getContent())
                .createdAt(question.getCreatedAt())
                .build();
    }
}
