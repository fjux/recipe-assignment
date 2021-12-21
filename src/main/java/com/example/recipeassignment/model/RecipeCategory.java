package com.example.recipeassignment.model;



import javax.persistence.*;
import java.util.List;

@Entity
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int recipeCategoryId;
    @Column(unique = true)
    private String category;
    @ManyToMany(
            cascade = {CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinTable(name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "fk_recipe_category_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_recipe_id"))
    private List<Recipe> recipes;

    public RecipeCategory() {
    }

    public RecipeCategory(int recipeCategoryId, String category, List<Recipe> recipes) {
        this.recipeCategoryId = recipeCategoryId;
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

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
