package com.example.recipeassignment.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueIngredientValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueIngredient {
    String message() default "";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};

}
