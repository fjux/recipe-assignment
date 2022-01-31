package com.example.recipeassignment.model.dto.form;

import com.example.recipeassignment.validation.OnPost;
import com.example.recipeassignment.validation.OnPut;
import com.example.recipeassignment.validation.UniqueIngredient;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

import static com.example.recipeassignment.validation.messages.ValidationMessages.MANDATORY_FIELD;
import static com.example.recipeassignment.validation.messages.ValidationMessages.UNIQUE_INGREDIENT;

public class IngredientForm implements Serializable {
    @NotBlank(message = MANDATORY_FIELD, groups = OnPut.class)
    private int ingredientId;
    @NotBlank( message = MANDATORY_FIELD, groups = {OnPost.class, OnPut.class})
    @UniqueIngredient(message = UNIQUE_INGREDIENT, groups = OnPost.class)
    private String ingredientName;

    public IngredientForm() {
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
