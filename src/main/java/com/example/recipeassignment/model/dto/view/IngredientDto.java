package com.example.recipeassignment.model.dto.view;

import java.io.Serializable;

public class IngredientDto implements Serializable {
    private int ingredientId;
    private String ingredientName;

    public IngredientDto(int ingredientId, String ingredientName) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
    }

    public IngredientDto() {
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
