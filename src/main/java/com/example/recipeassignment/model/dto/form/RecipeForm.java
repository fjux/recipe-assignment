package com.example.recipeassignment.model.dto.form;

import com.example.recipeassignment.validation.OnPost;
import com.example.recipeassignment.validation.OnPut;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

import static com.example.recipeassignment.validation.messages.ValidationMessages.MANDATORY_FIELD;

public class RecipeForm implements Serializable {

    @NotBlank(message = MANDATORY_FIELD, groups = OnPut.class)
    private int recipeId;
    @NotBlank(message = MANDATORY_FIELD, groups = {OnPost.class, OnPut.class})
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
