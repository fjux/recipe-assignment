package com.example.recipeassignment.service.entity;

import com.example.recipeassignment.model.dto.form.IngredientForm;
import com.example.recipeassignment.model.entity.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientEntityService extends GenericEntityService<Ingredient, IngredientForm, Integer> {
    Optional<Ingredient> findByIngredientNameIgnoreCase(String ingredientName);
    List<Ingredient> findAllByIngredientNameContains(String IngredientName);

}
