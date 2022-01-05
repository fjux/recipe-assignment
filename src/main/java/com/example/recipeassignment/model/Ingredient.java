package com.example.recipeassignment.model;

import javax.persistence.*;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false, name = "id")
    private int ingredientId;
    @Column(unique = true)
    private String ingredientName;

    public Ingredient(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Ingredient() {
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
