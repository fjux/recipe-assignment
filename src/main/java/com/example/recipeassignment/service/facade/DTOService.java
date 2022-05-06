package com.example.recipeassignment.service.facade;

import com.example.recipeassignment.model.dto.view.*;
import com.example.recipeassignment.model.entity.*;

public interface DTOService {
    IngredientDTO toIngredientDTO(Ingredient ingredient);

    RecipeInstructionDTO toRecipeInstructionDTO(RecipeInstruction recipeInstruction);

    RecipeIngredientDTO toSmallRecipeIngredientDTO(RecipeIngredient recipeIngredient);

    RecipeIngredientDTO toFullRecipeIngredientDTO(RecipeIngredient recipeIngredient);

    RecipeCategoryDTO toSmallRecipeCategoryDTO(RecipeCategory recipeCategory);

    RecipeCategoryDTO toFullRecipeCategoryDTO(RecipeCategory recipeCategory);

    RecipeDTO toSmallRecipeDTO(Recipe recipe);

    RecipeDTO toFullRecipeDTO(Recipe recipe);
}
