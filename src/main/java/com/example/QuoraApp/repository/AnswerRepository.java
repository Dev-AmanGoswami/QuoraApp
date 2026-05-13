package com.example.QuoraApp.repository;

import com.example.QuoraApp.model.Answer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AnswerRepository extends ReactiveMongoRepository<Answer, String> {
}
