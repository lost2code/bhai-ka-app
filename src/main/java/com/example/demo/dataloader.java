package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class dataloader implements CommandLineRunner {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void run(String... args) throws Exception {
        // Dummy quiz
        quiz quiz = new quiz();
        quiz.setTitle("General Knowledge Quiz");
        quiz.setCategory("GK");

        // Dummy questions
        question q1 = new question();
        q1.setText("What is the capital of India?");
        q1.setOption1("Mumbai");
        q1.setOption2("Delhi");
        q1.setOption3("Kolkata");
        q1.setOption4("Chennai");
        q1.setCorrectAnswer("option2");

        question q2 = new question();
        q2.setText("Which planet is known as the Red Planet?");
        q2.setOption1("Earth");
        q2.setOption2("Mars");
        q2.setOption3("Jupiter");
        q2.setOption4("Venus");
        q2.setCorrectAnswer("option2");

        quiz.setQuestions(Arrays.asList(q1, q2));
        quizRepository.save(quiz);
    }
}