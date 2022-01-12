package com.example.recipeassignment.model;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

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
    private Set<RecipeIngredient> ingredients;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_recipe_instruction_id")
    private RecipeInstruction instruction;
    @ManyToMany(
            cascade = {CascadeType.REFRESH, CascadeType.DETACH},
            fetch = FetchType.LAZY,
            mappedBy = "recipes"
    )
    private Set<RecipeCategory> categories;

    public Recipe() {
    }

    public Recipe(String recipeName, RecipeInstruction instruction) {
        this.recipeName = recipeName;
        this.instruction = instruction;
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

    public Set<RecipeIngredient> getIngredients() {
        if (ingredients == null) ingredients = new HashSet<>();
        return ingredients;
    }

    public void setIngredients(Set<RecipeIngredient> ingredients) {
        if (ingredients == null) ingredients = new HashSet<>();
        if (ingredients.isEmpty()){
            if (this.ingredients != null){
                this.ingredients.forEach(recipeIngredient -> recipeIngredient.setRecipe(this));
            }else {
                ingredients.forEach(recipeIngredient -> recipeIngredient.setRecipe(this));
            }
        }
        this.ingredients = ingredients;
    }


    public RecipeInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(RecipeInstruction instruction) {
        this.instruction = instruction;
    }

    public Set<RecipeCategory> getCategories() {
        if (categories == null) categories = new HashSet<>();
        return categories;
    }

    public void setCategories(Set<RecipeCategory> categories) {
        if (categories == null) categories = new HashSet<>();
        if (categories.isEmpty()){
            if (this.categories != null){
                this.categories.forEach(recipeCategory -> recipeCategory.addRecipe(null));
            }else {
                categories.forEach(recipeCategory -> recipeCategory.addRecipe(this));
            }
        }
        this.categories = categories;
    }

    public void addRecipeCategory(RecipeCategory recipeCategory){
        if (recipeCategory == null) throw new IllegalArgumentException("Recipe category was null");
        if (categories == null) categories = new HashSet<>();
        if (!categories.contains(recipeCategory)){
            categories.add(recipeCategory);
            recipeCategory.addRecipe(this);
        }
    }

    public void removeRecipeCategory(RecipeCategory recipeCategory){
        if (recipeCategory == null) throw new IllegalArgumentException("Recipe category was null");
        if (categories == null) categories = new HashSet<>();
        if (categories.contains(recipeCategory)) {
            categories.remove(recipeCategory);
            recipeCategory.removeRecipe(this);
        }
    }

    public void addRecipeIngredient(RecipeIngredient recipeIngredient){
        if (recipeIngredient == null) throw new IllegalArgumentException("Recipe category was null");
        if (ingredients == null) ingredients = new HashSet<>();
        if (!ingredients.contains(recipeIngredient)){
            ingredients.add(recipeIngredient);
            recipeIngredient.setRecipe(this);
        }
    }

    public void removeRecipeIngredient(RecipeIngredient recipeIngredient){
        if (recipeIngredient == null) throw new IllegalArgumentException("Recipe category was null");
        if (ingredients == null) ingredients = new HashSet<>();
        if (ingredients.contains(recipeIngredient)){
            ingredients.remove(recipeIngredient);
            recipeIngredient.setRecipe(null);
        }
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                ", ingredients=" + ingredients +
                ", instruction=" + instruction +
                ", categories=" + categories.stream().map(RecipeCategory::getCategory).collect(Collectors.toList()) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe)) return false;
        Recipe recipe = (Recipe) o;
        return getRecipeId() == recipe.getRecipeId() && getRecipeName().equals(recipe.getRecipeName()) && Objects.equals(getInstruction(), recipe.getInstruction());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipeId(), getRecipeName(), getInstruction());
    }
}

