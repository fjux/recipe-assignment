package com.example.recipeassignment.model.dto.view;

import java.io.Serializable;
import java.util.Set;

public class RecipeDto implements Serializable {
    private int recipeId;
    private String recipeName;
    private Set<RecipeIngredientDto> recipeIngredientDtos;
    private RecipeInstructionDto recipeInstructionDto;
    private Set<RecipeCategoryDto> recipeCategoryDtos;

    public RecipeDto(int recipeId, String recipeName, Set<RecipeIngredientDto> recipeIngredientDtos, RecipeInstructionDto recipeInstructionDto, Set<RecipeCategoryDto> recipeCategoryDtos) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeIngredientDtos = recipeIngredientDtos;
        this.recipeInstructionDto = recipeInstructionDto;
        this.recipeCategoryDtos = recipeCategoryDtos;
    }

    public RecipeDto() {
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

    public Set<RecipeIngredientDto> getRecipeIngredientDtos() {
        return recipeIngredientDtos;
    }

    public void setRecipeIngredientDtos(Set<RecipeIngredientDto> recipeIngredientDtos) {
        this.recipeIngredientDtos = recipeIngredientDtos;
    }

    public RecipeInstructionDto getRecipeInstructionDto() {
        return recipeInstructionDto;
    }

    public void setRecipeInstructionDto(RecipeInstructionDto recipeInstructionDto) {
        this.recipeInstructionDto = recipeInstructionDto;
    }

    public Set<RecipeCategoryDto> getRecipeCategoryDtos() {
        return recipeCategoryDtos;
    }

    public void setRecipeCategoryDtos(Set<RecipeCategoryDto> recipeCategoryDtos) {
        this.recipeCategoryDtos = recipeCategoryDtos;
    }
}
