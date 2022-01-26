package com.example.recipeassignment.service.facade;

import com.example.recipeassignment.model.dto.form.IngredientForm;
import com.example.recipeassignment.model.dto.view.IngredientDTO;
import com.example.recipeassignment.service.entity.GenericEntityService;

import java.util.List;
import java.util.Optional;

public interface IngredientService extends GenericEntityService<IngredientDTO, IngredientForm, Integer> {
    IngredientDTO findByIngredientNameIgnoreCase(String ingredientName);
    List<IngredientDTO> findByIngredientNameContains(String ingredientName);
}
