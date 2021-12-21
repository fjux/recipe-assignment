package com.example.recipeassignment.data;

import com.example.recipeassignment.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientDAO extends JpaRepository<Ingredient, Integer> {
    Ingredient findIngredientByIngredientNameEquals(String name);


}
