package com.example.recipeassignment.model.dto.form;

import java.io.Serializable;

public class RecipeForm implements Serializable {

    private int recipeId;
    private String recipeName;
    private RecipeInstructionForm recipeInstruction;

    public RecipeForm() {
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

    public RecipeInstructionForm getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstructionForm(RecipeInstructionForm recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }
}
