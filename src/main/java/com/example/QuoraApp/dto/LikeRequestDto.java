package com.example.QuoraApp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LikeRequestDto {
    @NotNull(message = "Target Type is required.")
    private String targetType;

    @NotNull(message = "Target Id is required.")
    private String targetId;

    @NotNull(message = "Is Like is required.")
    private Boolean isLike;
}
