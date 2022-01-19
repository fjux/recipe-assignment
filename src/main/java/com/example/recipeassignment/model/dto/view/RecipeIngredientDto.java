package com.example.recipeassignment.model.dto.view;

import com.example.recipeassignment.model.constants.Measurement;

import java.io.Serializable;

public class RecipeIngredientDto implements Serializable {
    private String recipeIngredientId;
    private IngredientDto ingredient;
    private double amount;
    private Measurement measurement;
    private RecipeDto recipe;

    public RecipeIngredientDto() {
    }

    public RecipeIngredientDto(String recipeIngredientId, IngredientDto ingredient, double amount, Measurement measurement, RecipeDto recipe) {
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

    public IngredientDto getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientDto ingredient) {
        this.ingredient = ingredient;
    }

    public RecipeDto getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeDto recipe) {
        this.recipe = recipe;
    }
}
