package com.example.recipeassignment.model;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int recipeCategoryId;
    @Column(unique = true)
    private String category;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "fk_recipe_category_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_recipe_id"))
    private Set<Recipe> recipes;

    public RecipeCategory() {
    }

    public RecipeCategory(String category) {
        this.category = category;
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

    public Set<Recipe> getRecipes() {
        if (recipes == null) recipes = new HashSet<>();
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        if (recipes == null) recipes = new HashSet<>();
        if (recipes.isEmpty()) {
            if (this.recipes != null) {
                this.recipes.forEach(recipe -> recipe.addRecipeCategory(this));
            } else {
                recipes.forEach(recipe -> recipe.addRecipeCategory(this));
            }
        }
        this.recipes = recipes;
    }

    public void addRecipe(Recipe recipe) {
        if (recipe == null) throw new IllegalArgumentException("Recipe was null");
        if (recipes == null) recipes = new HashSet<>();
        if (!recipes.contains(recipe)) {
            recipes.add(recipe);
            recipe.addRecipeCategory(this);
        }
    }

    public void removeRecipe(Recipe recipe) {
        if (recipe == null) throw new IllegalArgumentException("Recipe was null");
        if (recipes == null) recipes = new HashSet<>();
        if (recipes.contains(recipe)) {
            recipes.remove(recipe);
            recipe.removeRecipeCategory(this);
        }
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "recipeCategoryId=" + recipeCategoryId +
                ", category='" + category + '\'' +
                ", recipes=" + recipes.stream().map(Recipe::getRecipeName).toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeCategory)) return false;
        RecipeCategory that = (RecipeCategory) o;
        return getRecipeCategoryId() == that.getRecipeCategoryId() && getCategory().equals(that.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipeCategoryId(), getCategory());
    }
}