package com.example.recipeassignment.service.entity;

import com.example.recipeassignment.model.dto.form.RecipeForm;
import com.example.recipeassignment.model.entity.Recipe;
import com.example.recipeassignment.model.entity.RecipeCategory;
import com.example.recipeassignment.model.entity.RecipeIngredient;

import java.util.List;

public interface RecipeEntityService extends GenericEntityService<Recipe, RecipeForm, Integer>{
    List<Recipe> findByRecipeNameContains(String recipeName);
    List<Recipe> findByIngredientName(String ingredientName);
    List<Recipe> findByCategory(String categoryName);
    List<Recipe> findByCategories(String... categories);
    Recipe addRecipeIngredient(Integer recipeId, RecipeIngredient recipeIngredient);
    Recipe removeRecipeIngredient(Integer recipeId, RecipeIngredient recipeIngredient);
    Recipe addRecipeCategory(Integer recipeId, RecipeCategory recipeCategory);
    Recipe removeRecipeCategory(Integer recipeId, RecipeCategory recipeCategory);
}
