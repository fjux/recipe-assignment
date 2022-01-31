package com.example.recipeassignment.data;

import com.example.recipeassignment.model.entity.RecipeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeCategoryRepository extends JpaRepository<RecipeCategory, Integer> {
    Optional<RecipeCategory> findByCategoryIgnoreCase(String category);
}
