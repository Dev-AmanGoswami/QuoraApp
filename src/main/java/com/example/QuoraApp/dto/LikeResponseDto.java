package com.example.QuoraApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LikeResponseDto {
    private String id;

    private String targetType;

    private String targetId;

    private Boolean isLike;

    private LocalDateTime createdAt;
}
