package com.example.recipeassignment.service.entity;

import com.example.recipeassignment.model.dto.form.RecipeCategoryForm;
import com.example.recipeassignment.model.entity.Recipe;
import com.example.recipeassignment.model.entity.RecipeCategory;

public interface RecipeCategoryEntityService extends GenericEntityService<RecipeCategory, RecipeCategoryForm, Integer> {
    RecipeCategory addRecipe(Integer recipeCategoryId, Recipe recipe);
    RecipeCategory removeRecipe(Integer recipeCategoryId, Recipe recipe);
}
