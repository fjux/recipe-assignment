package com.example.recipeassignment.data;

import com.example.recipeassignment.model.RecipeInstruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeInstructionRepository extends JpaRepository<RecipeInstruction, String> {
}
