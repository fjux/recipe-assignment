package com.example.recipeassignment.validation;

import com.example.recipeassignment.data.RecipeCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCategoryValidator implements ConstraintValidator<UniqueCategory, String> {

    private final RecipeCategoryRepository recipeCategoryRepository;

    @Autowired
    public UniqueCategoryValidator(RecipeCategoryRepository recipeCategoryRepository) {
        this.recipeCategoryRepository = recipeCategoryRepository;
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null){
            return true;
        }
        return !recipeCategoryRepository.findByCategoryIgnoreCase(value).isPresent();
    }
}
