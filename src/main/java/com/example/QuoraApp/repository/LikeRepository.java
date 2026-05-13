package com.example.QuoraApp.repository;

import com.example.QuoraApp.model.Like;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface LikeRepository extends ReactiveMongoRepository<Like, String> {
}
