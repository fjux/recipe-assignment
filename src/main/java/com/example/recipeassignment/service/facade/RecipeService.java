package com.example.recipeassignment.service.facade;

import com.example.recipeassignment.model.dto.form.RecipeForm;
import com.example.recipeassignment.model.dto.view.RecipeDTO;
import com.example.recipeassignment.model.entity.RecipeCategory;
import com.example.recipeassignment.model.entity.RecipeIngredient;
import com.example.recipeassignment.service.entity.GenericEntityService;

import java.util.List;

public interface RecipeService extends GenericEntityService<RecipeDTO, RecipeForm, Integer> {
    List<RecipeDTO> findByRecipeNameContains(String recipeName);
    List<RecipeDTO> findByIngredientName(String ingredientName);
    List<RecipeDTO> findByCategory(String category);
    List<RecipeDTO> findByCategories(String... categories);
    RecipeDTO addRecipeIngredient(Integer recipeId, RecipeIngredient recipeIngredient);
    RecipeDTO removeRecipeIngredient(Integer recipeId, RecipeIngredient recipeIngredient);
    RecipeDTO addRecipeCategory(Integer recipeId, RecipeCategory recipeCategory);
    RecipeDTO removeRecipeCategory(Integer recipeId, RecipeCategory recipeCategory);
}
