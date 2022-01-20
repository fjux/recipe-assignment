package com.example.recipeassignment.service.facade;

import com.example.recipeassignment.model.dto.form.RecipeInstructionForm;
import com.example.recipeassignment.model.dto.view.RecipeInstructionDTO;
import com.example.recipeassignment.service.entity.GenericEntityService;

public interface RecipeInstructionService extends GenericEntityService<RecipeInstructionDTO, RecipeInstructionForm, String> {
}
