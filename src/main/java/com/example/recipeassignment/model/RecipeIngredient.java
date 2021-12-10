package com.example.recipeassignment.model;

import com.example.recipeassignment.model.constants.EntityConstants;
import com.example.recipeassignment.model.constants.Measurement;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import static com.example.recipeassignment.model.constants.EntityConstants.GENERATOR;
import static com.example.recipeassignment.model.constants.EntityConstants.UUID_GENERATOR;

@Entity
public class RecipeIngredient {
    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name = GENERATOR, strategy = UUID_GENERATOR)
    @Column(updatable = false)
    private String id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_ingredient_id", table = "ingredient")
    private Ingredient ingredient;
    private double amount;
    private Measurement measurement;
    @ManyToOne
    private Recipe recipe;

    public RecipeIngredient() {
    }

    public RecipeIngredient(String id, Ingredient ingredient, double amount, Measurement measurement, Recipe recipe) {
        this.id = id;
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
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

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
