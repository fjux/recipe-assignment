package com.example.recipeassignment.model.dto.form;

import java.io.Serializable;

public class IngredientForm implements Serializable {
    private int ingredientId;
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
