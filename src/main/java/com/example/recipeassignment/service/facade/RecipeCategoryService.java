package com.example.recipeassignment.service.facade;

import com.example.recipeassignment.model.dto.form.RecipeCategoryForm;
import com.example.recipeassignment.model.dto.view.RecipeCategoryDTO;
import com.example.recipeassignment.model.dto.view.RecipeDTO;
import com.example.recipeassignment.service.entity.GenericEntityService;

public interface RecipeCategoryService extends GenericEntityService<RecipeCategoryDTO, RecipeCategoryForm, Integer> {
    RecipeCategoryDTO addRecipe(Integer recipeCategoryId, RecipeDTO recipe);
    RecipeCategoryDTO removeRecipe(Integer recipeCategoryId, RecipeDTO recipe);
}
