package com.example.recipeassignment.model;

import java.util.List;

public class RecipeCategory {
    private int id;
    private String category;
    private List<Recipe> recipes;

    public RecipeCategory() {
    }

    public RecipeCategory(int id, String category, List<Recipe> recipes) {
        this.id = id;
        this.category = category;
        this.recipes = recipes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
