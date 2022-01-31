package com.example.recipeassignment.exception;

public class AppResourceNotFoundException extends RuntimeException{
    public AppResourceNotFoundException(String message) {
        super(message);
    }
}
