package com.example.recipeassignment.model.dto.view;

import java.io.Serializable;
import java.util.Set;

public class RecipeDTO implements Serializable {
    private int recipeId;
    private String recipeName;
    private Set<RecipeIngredientDTO> recipeIngredientDTOS;
    private RecipeInstructionDTO recipeInstructionDto;
    private Set<RecipeCategoryDTO> recipeCategoryDTOS;

    public RecipeDTO(int recipeId, String recipeName, Set<RecipeIngredientDTO> recipeIngredientDTOS, RecipeInstructionDTO recipeInstructionDto, Set<RecipeCategoryDTO> recipeCategoryDTOS) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeIngredientDTOS = recipeIngredientDTOS;
        this.recipeInstructionDto = recipeInstructionDto;
        this.recipeCategoryDTOS = recipeCategoryDTOS;
    }

    public RecipeDTO() {
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Set<RecipeIngredientDTO> getRecipeIngredientDtos() {
        return recipeIngredientDTOS;
    }

    public void setRecipeIngredientDtos(Set<RecipeIngredientDTO> recipeIngredientDTOS) {
        this.recipeIngredientDTOS = recipeIngredientDTOS;
    }

    public RecipeInstructionDTO getRecipeInstructionDto() {
        return recipeInstructionDto;
    }

    public void setRecipeInstructionDto(RecipeInstructionDTO recipeInstructionDto) {
        this.recipeInstructionDto = recipeInstructionDto;
    }

    public Set<RecipeCategoryDTO> getRecipeCategoryDtos() {
        return recipeCategoryDTOS;
    }

    public void setRecipeCategoryDtos(Set<RecipeCategoryDTO> recipeCategoryDTOS) {
        this.recipeCategoryDTOS = recipeCategoryDTOS;
    }
}
