package com.example.QuoraApp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerRequestDto {
    @NotBlank(message = "Content is required")
    @Size(min = 10, message = "Content must be at least of 10 characters")
    private String content;

    @NotBlank(message = "QuestionId is required")
    private String questionId;
}
