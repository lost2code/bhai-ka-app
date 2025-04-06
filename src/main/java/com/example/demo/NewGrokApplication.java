package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
@Controller
public class NewGrokApplication {

    @Autowired
    private QuizRepository quizRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<quiz> quizzes = quizRepository.findAll();
        model.addAttribute("quizzes", quizzes);
        return "quiz-list"; // Template ka naam
    }

    @GetMapping("/quiz/{id}")
    public String startQuiz(@PathVariable Long id, Model model) {
        quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        model.addAttribute("quiz", quiz);
        return "quiz-play"; // Template ka naam
    }
    
    public static void main(String[] args) {
        SpringApplication.run(NewGrokApplication.class, args);
    }
}
	
	
	
	
	
	
	
	
	
	
		
	
	
	
	
	
	
	
	
	






    
