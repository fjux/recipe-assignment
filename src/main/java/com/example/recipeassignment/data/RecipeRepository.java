package com.example.recipeassignment.data;

import com.example.recipeassignment.model.Recipe;
import com.example.recipeassignment.model.RecipeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    @Query("SELECT r FROM Recipe r WHERE UPPER(r.recipeName) LIKE UPPER(CONCAT('%', :name, '%'))")
    List<Recipe> findByRecipeNameContains(@Param("name") String name);
    @Query("SELECT r FROM Recipe r, RecipeIngredient ri, Ingredient i WHERE i = ri.ingredient AND ri MEMBER OF r.ingredients AND i.ingredientName = :name")
    List<Recipe> findByIngredientName(@Param("name") String name);
    @Query("SELECT r FROM Recipe r JOIN r.categories c WHERE UPPER(c.category) =:category")
    List<Recipe> findByCategory(@Param("category") String category);
    @Query("SELECT r FROM Recipe r JOIN r.categories c WHERE c.category IN :categories")
    List<Recipe> findByCategories(@Param("categories") Collection<RecipeCategory> categories);
}
