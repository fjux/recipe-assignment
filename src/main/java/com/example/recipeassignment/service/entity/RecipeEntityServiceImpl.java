package com.example.recipeassignment.service.entity;

import com.example.recipeassignment.data.RecipeRepository;
import com.example.recipeassignment.model.dto.form.RecipeForm;
import com.example.recipeassignment.model.entity.Recipe;
import com.example.recipeassignment.model.entity.RecipeCategory;
import com.example.recipeassignment.model.entity.RecipeIngredient;

import java.util.List;

public class RecipeEntityServiceImpl implements RecipeEntityService{
    private final RecipeRepository recipeRepository;
    private final RecipeInstructionEntityService recipeInstructionEntityService;

    public RecipeEntityServiceImpl(RecipeRepository recipeRepository, RecipeInstructionEntityService recipeInstructionEntityService) {
        this.recipeRepository = recipeRepository;
        this.recipeInstructionEntityService = recipeInstructionEntityService;
    }

    @Override
    public Recipe create(RecipeForm recipeForm) {
        if (recipeForm == null) throw new IllegalArgumentException("Recipe form was null");
        Recipe recipe = new Recipe();
        recipe.setRecipeName(recipeForm.getRecipeName());
        recipe.setInstruction(recipeInstructionEntityService.create(recipeForm.getRecipeInstruction()));
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe findById(Integer recipeId) {
        return recipeRepository.findById(recipeId).orElseThrow(() -> new IllegalArgumentException("Could not find a recipe with id" + recipeId));
    }

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe update(Integer recipeId, RecipeForm recipeForm) {
        if (recipeForm == null) throw new IllegalArgumentException("Recipe form was null");
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new IllegalArgumentException("Could not find a recipe with id" + recipeId));
        recipe.setRecipeName(recipeForm.getRecipeName());
        return recipeRepository.save(recipe);
    }

    @Override
    public void delete(Integer recipeId) {
        recipeRepository.deleteById(recipeId);

    }

    @Override
    public List<Recipe> findByRecipeNameContains(String recipeName) {
        return recipeRepository.findByRecipeNameContains(recipeName);
    }

    @Override
    public List<Recipe> findByIngredientName(String ingredientName) {
        return recipeRepository.findByIngredientName(ingredientName);
    }

    @Override
    public List<Recipe> findByCategory(String categoryName) {
        return recipeRepository.findByCategory(categoryName);
    }

    @Override
    public List<Recipe> findByCategories(String... categories) {
        return recipeRepository.findByCategories(categories);
    }

    @Override
    public Recipe addRecipeIngredient(Integer recipeId, RecipeIngredient recipeIngredient) {
        if (recipeIngredient == null) throw new IllegalArgumentException("Recipe ingredient was null");
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new IllegalArgumentException("Could not find a recipe with id" + recipeId));
        recipe.addRecipeIngredient(recipeIngredient);
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe removeRecipeIngredient(Integer recipeId, RecipeIngredient recipeIngredient) {
        if (recipeIngredient == null) throw new IllegalArgumentException("Recipe ingredient was null");
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new IllegalArgumentException("Could not find a recipe with id" + recipeId));
        recipe.removeRecipeIngredient(recipeIngredient);
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe addRecipeCategory(Integer recipeId, RecipeCategory recipeCategory) {
        if (recipeCategory == null) throw new IllegalArgumentException("Recipe category was null");
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new IllegalArgumentException("Could not find a recipe with id" + recipeId));
        recipe.addRecipeCategory(recipeCategory);
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe removeRecipeCategory(Integer recipeId, RecipeCategory recipeCategory) {
        if (recipeCategory == null) throw new IllegalArgumentException("Recipe category was null");
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new IllegalArgumentException("Could not find a recipe with id" + recipeId));
        recipe.removeRecipeCategory(recipeCategory);
        return recipeRepository.save(recipe);
    }
}
