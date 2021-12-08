package com.example.recipeassignment.model;

import java.util.List;

public class Recipe {
    private int id;
    private String name;
    private List<RecipeIngredient> ingredients;
    private RecipeInstruction instruction;
    private List<RecipeCategory> categories;

    public Recipe() {
    }

    public Recipe(String name, List<RecipeIngredient> ingredients, RecipeInstruction instruction, List<RecipeCategory> categories) {
        this.name = name;
        this.ingredients = ingredients;
        this.instruction = instruction;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public RecipeInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(RecipeInstruction instruction) {
        this.instruction = instruction;
    }

    public List<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<RecipeCategory> categories) {
        this.categories = categories;
    }
}
