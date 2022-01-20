package com.example.recipeassignment.model.dto.view;

import com.example.recipeassignment.model.constants.Measurement;

import java.io.Serializable;

public class RecipeIngredientDTO implements Serializable {
    private String recipeIngredientId;
    private IngredientDTO ingredient;
    private double amount;
    private Measurement measurement;
    private RecipeDTO recipe;

    public RecipeIngredientDTO() {
    }

    public RecipeIngredientDTO(String recipeIngredientId, IngredientDTO ingredient, double amount, Measurement measurement, RecipeDTO recipe) {
        this.recipeIngredientId = recipeIngredientId;
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public String getRecipeIngredientId() {
        return recipeIngredientId;
    }

    public void setRecipeIngredientId(String recipeIngredientId) {
        this.recipeIngredientId = recipeIngredientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public IngredientDTO getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientDTO ingredient) {
        this.ingredient = ingredient;
    }

    public RecipeDTO getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeDTO recipe) {
        this.recipe = recipe;
    }
}
