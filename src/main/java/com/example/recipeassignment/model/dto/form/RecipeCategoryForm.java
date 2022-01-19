package com.example.recipeassignment.model.dto.form;

import java.io.Serializable;

public class RecipeCategoryForm implements Serializable {

    private int recipeCategoryId;
    private String category;

    public RecipeCategoryForm() {
    }

    public int getRecipeCategoryId() {
        return recipeCategoryId;
    }

    public void setRecipeCategoryId(int recipeCategoryId) {
        this.recipeCategoryId = recipeCategoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
