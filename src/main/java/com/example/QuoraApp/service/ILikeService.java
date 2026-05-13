package com.example.QuoraApp.service;

import com.example.QuoraApp.dto.LikeRequestDto;
import com.example.QuoraApp.dto.LikeResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ILikeService{
    Mono<LikeResponseDto> createLike(LikeRequestDto requestDto);

    Mono<LikeResponseDto> countLikesByTargetIdAndTargetType(String targetId, String targetType);

    Mono<LikeResponseDto> countDislikesByTargetIdAndTargetType(String targetId, String targetType);

    Mono<LikeResponseDto> toggleLike(String targetId, String targetType, Boolean isLike);
}
