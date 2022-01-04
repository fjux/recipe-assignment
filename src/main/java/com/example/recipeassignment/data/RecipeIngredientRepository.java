package com.example.recipeassignment.data;

import com.example.recipeassignment.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, String> {
}
