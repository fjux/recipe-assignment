package com.example.recipeassignment.model.dto.view;

import java.io.Serializable;
import java.util.Set;

public class RecipeCategoryDTO implements Serializable {
    private int recipeCategoryId;
    private String category;
    private Set<RecipeDTO> recipeDTOS;

    public RecipeCategoryDTO(int recipeCategoryId, String category, Set<RecipeDTO> recipeDTOS) {
        this.recipeCategoryId = recipeCategoryId;
        this.category = category;
        this.recipeDTOS = recipeDTOS;
    }

    public RecipeCategoryDTO() {
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

    public Set<RecipeDTO> getRecipeDTOS() {
        return recipeDTOS;
    }

    public void setRecipeDTOS(Set<RecipeDTO> recipeDTOS) {
        this.recipeDTOS = recipeDTOS;
    }
}
