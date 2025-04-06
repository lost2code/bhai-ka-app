package com.example.demo;
import jakarta.persistence.*;
import java.util.List;

public class quiz {
	
	@Entity
	public class Quiz {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String title;
	    private String category;

	    @OneToMany
	    private List<question> questions;

	    // Getters and Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getCategory() {
	        return category;
	    }

	    public void setCategory(String category) {
	        this.category = category;
	    }

	    public List<question> getQuestions() {
	        return questions;
	    }

	    public void setQuestions(List<question> questions) {
	        this.questions = questions;
	    }
	}

}
