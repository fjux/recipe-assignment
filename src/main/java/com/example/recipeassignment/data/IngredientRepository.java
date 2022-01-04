package com.example.recipeassignment.data;

import com.example.recipeassignment.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    Optional<Ingredient> findByIngredientNameIgnoreCase(String name);
    List<Ingredient> findByIngredientNameContains(String name);



}
