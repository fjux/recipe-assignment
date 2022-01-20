package com.example.recipeassignment.service.facade;

import com.example.recipeassignment.model.dto.form.*;
import com.example.recipeassignment.model.dto.view.*;

public interface DTOService {
    IngredientDTO toIngredientDTO(IngredientForm ingredient);

    RecipeInstructionDTO toRecipeInstructionDTO(RecipeInstructionForm recipeInstruction);

    RecipeIngredientDTO toSmallRecipeIngredientDTO(RecipeIngredientForm recipeIngredient);

    RecipeIngredientDTO toFullRecipeIngredientDTO(RecipeIngredientForm recipeIngredient);

    RecipeCategoryDTO toSmallRecipeCategoryDTO(RecipeCategoryForm recipeCategory);

    RecipeCategoryDTO toFullRecipeCategoryDTO(RecipeCategoryForm recipeCategory);

    RecipeDTO toSmallRecipeDTO(RecipeForm recipe);

    RecipeDTO foFullRecipeDTO(RecipeForm recipe);
}
