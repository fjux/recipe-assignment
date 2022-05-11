package com.example.recipeassignment.validation;

import com.example.recipeassignment.data.AppUserRepository;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final AppUserRepository appUserRepository;

    public UniqueEmailValidator(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if(email == null) return true;
        return appUserRepository.findByEmail(email).isEmpty();
    }
}
