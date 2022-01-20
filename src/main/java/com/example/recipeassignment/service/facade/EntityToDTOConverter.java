package com.example.recipeassignment.service.facade;

import com.example.recipeassignment.model.dto.form.*;
import com.example.recipeassignment.model.dto.view.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class EntityToDTOConverter implements DTOService{
    @Override
    public IngredientDTO toIngredientDTO(IngredientForm ingredient) {
        return null;
    }

    @Override
    public RecipeInstructionDTO toRecipeInstructionDTO(RecipeInstructionForm recipeInstruction) {
        return null;
    }

    @Override
    public RecipeIngredientDTO toSmallRecipeIngredientDTO(RecipeIngredientForm recipeIngredient) {
        return null;
    }

    @Override
    public RecipeIngredientDTO toFullRecipeIngredientDTO(RecipeIngredientForm recipeIngredient) {
        return null;
    }

    @Override
    public RecipeCategoryDTO toSmallRecipeCategoryDTO(RecipeCategoryForm recipeCategory) {
        return null;
    }

    @Override
    public RecipeCategoryDTO toFullRecipeCategoryDTO(RecipeCategoryForm recipeCategory) {
        return null;
    }

    @Override
    public RecipeDTO toSmallRecipeDTO(RecipeForm recipe) {
        return null;
    }

    @Override
    public RecipeDTO foFullRecipeDTO(RecipeForm recipe) {
        return null;
    }
}
