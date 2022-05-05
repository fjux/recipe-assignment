package com.example.recipeassignment.validation.messages;

public class ValidationMessages {
    public static final String UNIQUE_INGREDIENT = "The ingredient already exists";
    public static final String UNIQUE_CATEGORY = "The category already exists";
    public static final String MANDATORY_FIELD = "This field is mandatory";
    public static final String USERNAME_SIZE = "Username needs to have between 6 and 100 characters";
    public static final String USERNAME_TAKEN = "Username already taken";
    public static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
    public static final String WEAK_PASSWORD = "The password is to weak. 8 characters with at least one number and one letter";

}
