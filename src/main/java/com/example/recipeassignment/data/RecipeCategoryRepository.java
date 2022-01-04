package com.example.recipeassignment.data;

import com.example.recipeassignment.model.RecipeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeCategoryRepository extends JpaRepository<RecipeCategory, Integer> {
}
