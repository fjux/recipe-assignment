package com.example.recipeassignment.service.facade;

import com.example.recipeassignment.model.dto.form.RecipeCategoryForm;
import com.example.recipeassignment.model.dto.view.RecipeCategoryDTO;
import com.example.recipeassignment.model.entity.Recipe;
import com.example.recipeassignment.service.entity.GenericEntityService;

public interface RecipeCategoryService extends GenericEntityService<RecipeCategoryDTO, RecipeCategoryForm, Integer> {
    RecipeCategoryDTO addRecipe(Integer recipeCategoryId, Recipe recipe);
    RecipeCategoryDTO removeRecipe(Integer recipeCategoryId, Recipe recipe);
    RecipeCategoryDTO findByCategoryIgnoreCase(String category);
}
