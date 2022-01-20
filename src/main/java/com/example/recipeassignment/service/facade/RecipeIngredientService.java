package com.example.recipeassignment.service.facade;

import com.example.recipeassignment.model.dto.form.RecipeIngredientForm;
import com.example.recipeassignment.model.dto.view.RecipeIngredientDTO;
import com.example.recipeassignment.service.entity.GenericEntityService;

public interface RecipeIngredientService extends GenericEntityService<RecipeIngredientDTO, RecipeIngredientForm, String> {
}
