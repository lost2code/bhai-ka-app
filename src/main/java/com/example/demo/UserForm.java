package com.example.demo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserForm {

    @NotBlank(message = "Naam toh daal, bhai!")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Naam mein sirf letters hone chahiye, bhai!")
    private String name;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}