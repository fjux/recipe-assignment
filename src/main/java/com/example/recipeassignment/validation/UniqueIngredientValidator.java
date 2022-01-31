package com.example.recipeassignment.validation;

import com.example.recipeassignment.data.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueIngredientValidator implements ConstraintValidator<UniqueIngredient, String> {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public UniqueIngredientValidator(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null){
            return true;
        }
        return !ingredientRepository.findByIngredientNameIgnoreCase(value).isPresent();
    }
}
