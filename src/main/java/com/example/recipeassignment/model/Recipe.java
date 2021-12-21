package com.example.recipeassignment.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, name = "id")
    private int recipeId;
    private String recipeName;
    @OneToMany(
            cascade = {CascadeType.REFRESH, CascadeType.DETACH},
            fetch = FetchType.LAZY,
            mappedBy = "recipe"
    )
    private List<RecipeIngredient> ingredients;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_recipe_instruction_id" )
    private RecipeInstruction instruction;
    @ManyToMany(
            cascade = {CascadeType.REFRESH, CascadeType.DETACH},
            fetch = FetchType.LAZY,
            mappedBy = "recipes"
    )
    private List<RecipeCategory> categories;

    public Recipe() {
    }

    public Recipe(String recipeName, List<RecipeIngredient> ingredients, RecipeInstruction instruction, List<RecipeCategory> categories) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.instruction = instruction;
        this.categories = categories;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
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
