package com.example.recipeassignment.model;



import javax.persistence.*;
import java.util.Set;

@Entity
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int recipeCategoryId;
    @Column(unique = true)
    private String category;
    @ManyToMany( cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "fk_recipe_category_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_recipe_id"))
    private Set<Recipe> recipes;

    public RecipeCategory() {
    }

    public RecipeCategory(String category, Set<Recipe> recipes) {
        this.category = category;
        this.recipes = recipes;
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
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

}
