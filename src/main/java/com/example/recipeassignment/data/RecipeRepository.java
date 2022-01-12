package com.example.recipeassignment.data;

import com.example.recipeassignment.model.Recipe;
import com.example.recipeassignment.model.RecipeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    @Query("SELECT r FROM Recipe r WHERE UPPER(r.recipeName) LIKE UPPER(CONCAT('%', :name, '%'))")
    List<Recipe> findByRecipeNameContains(@Param("name") String name);
    @Query("SELECT r FROM Recipe r JOIN FETCH r.ingredients AS ri WHERE UPPER(ri.ingredient.ingredientName) = UPPER(:name)")
    List<Recipe> findByIngredientName(@Param("name") String name);
    @Query("SELECT r FROM Recipe r JOIN FETCH r.categories AS c WHERE UPPER(c.category) = UPPER(:category)")
    List<Recipe> findByCategory(@Param("category") String category);
    @Query("SELECT DISTINCT r FROM Recipe r JOIN FETCH r.categories AS c WHERE c.category IN :kategorier")
    List<Recipe> findByCategories(@Param("kategorier") String... kategorier);
}
