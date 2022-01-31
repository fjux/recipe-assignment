package com.example.recipeassignment.model.dto.form;

import com.example.recipeassignment.model.constants.Measurement;
import com.example.recipeassignment.validation.OnPost;
import com.example.recipeassignment.validation.OnPut;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static com.example.recipeassignment.validation.messages.ValidationMessages.MANDATORY_FIELD;

public class RecipeIngredientForm implements Serializable {

    @NotBlank(message = MANDATORY_FIELD, groups = OnPut.class)
    private String recipeIngredientId;
    @NotNull(message = MANDATORY_FIELD, groups = OnPost.class)
    private IngredientForm ingredient;
    private double amount;
    private Measurement measurement;
    private RecipeForm recipe;

    public RecipeIngredientForm() {
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

    public IngredientForm getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientForm ingredient) {
        this.ingredient = ingredient;
    }

    public RecipeForm getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeForm recipe) {
        this.recipe = recipe;
    }
}
