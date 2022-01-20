package com.example.recipeassignment.service.facade;

import com.example.recipeassignment.model.dto.form.RecipeForm;
import com.example.recipeassignment.model.dto.view.RecipeCategoryDTO;
import com.example.recipeassignment.model.dto.view.RecipeDTO;
import com.example.recipeassignment.model.dto.view.RecipeIngredientDTO;
import com.example.recipeassignment.service.entity.GenericEntityService;

import java.util.List;

public interface RecipeService extends GenericEntityService<RecipeDTO, RecipeForm, Integer> {
    List<RecipeDTO> findByRecipeNameContains(String recipeName);
    List<RecipeDTO> findByIngredientName(String ingredientName);
    List<RecipeDTO> findByCategory(String category);
    List<RecipeDTO> findByCategories(String... categories);
    RecipeDTO addRecipeIngredient(Integer recipeId, RecipeIngredientDTO recipeIngredient);
    RecipeDTO removeRecipeIngredient(Integer recipeId, RecipeIngredientDTO recipeIngredient);
    RecipeDTO addRecipeCategory(Integer recipeId, RecipeCategoryDTO recipeCategory);
    RecipeDTO removeRecipeCategory(Integer recipeId, RecipeCategoryDTO recipeCategory);
}
