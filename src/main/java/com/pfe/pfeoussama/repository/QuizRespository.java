package com.pfe.pfeoussama.repository;

import com.pfe.pfeoussama.models.Quiz;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuizRespository extends MongoRepository<Quiz, String> {
}
