package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<quiz, Long> {
}
