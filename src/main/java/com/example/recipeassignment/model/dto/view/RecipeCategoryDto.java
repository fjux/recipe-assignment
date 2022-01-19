package com.example.recipeassignment.model.dto.view;

import java.io.Serializable;
import java.util.Set;

public class RecipeCategoryDto implements Serializable {
    private int recipeCategoryId;
    private String category;
    private Set<RecipeDto> recipeDtos;

    public RecipeCategoryDto(int recipeCategoryId, String category, Set<RecipeDto> recipeDtos) {
        this.recipeCategoryId = recipeCategoryId;
        this.category = category;
        this.recipeDtos= recipeDtos;
    }

    public RecipeCategoryDto() {
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

    public Set<RecipeDto> getRecipeDtos() {
        return recipeDtos;
    }

    public void setRecipeDtos(Set<RecipeDto> recipeDtos) {
        this.recipeDtos = recipeDtos;
    }
}
