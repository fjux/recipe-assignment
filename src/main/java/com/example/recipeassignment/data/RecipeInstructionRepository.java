package com.example.recipeassignment.data;

import com.example.recipeassignment.model.RecipeInstruction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeInstructionRepository extends JpaRepository<RecipeInstruction, String> {
}
