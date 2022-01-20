package com.example.recipeassignment.service.entity;

import com.example.recipeassignment.data.RecipeCategoryRepository;
import com.example.recipeassignment.model.dto.form.RecipeCategoryForm;
import com.example.recipeassignment.model.entity.Recipe;
import com.example.recipeassignment.model.entity.RecipeCategory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RecipeCategoryEntityServiceImpl implements RecipeCategoryEntityService{
    private final RecipeCategoryRepository recipeCategoryRepository;

    public RecipeCategoryEntityServiceImpl(RecipeCategoryRepository recipeCategoryRepository) {
        this.recipeCategoryRepository = recipeCategoryRepository;
    }

    @Override
    public RecipeCategory create(RecipeCategoryForm recipeCategoryForm) {
        if (recipeCategoryForm == null) throw new IllegalArgumentException("Recipe category form was null");
        RecipeCategory recipeCategory = new RecipeCategory();
        recipeCategory.setCategory(recipeCategoryForm.getCategory());
        return recipeCategoryRepository.save(recipeCategory);
    }

    @Override
    public RecipeCategory findById(Integer recipeCategoryId) {
        return recipeCategoryRepository.findById(recipeCategoryId).orElseThrow(() -> new IllegalArgumentException("Could not find a recipe category with id " + recipeCategoryId));
    }

    @Override
    public List<RecipeCategory> findAll() {
        return recipeCategoryRepository.findAll();
    }

    @Override
    public RecipeCategory update(Integer recipeCategoryId, RecipeCategoryForm recipeCategoryForm) {
        if (recipeCategoryForm == null) throw new IllegalArgumentException("Recipe category form was null");
        RecipeCategory recipeCategory = recipeCategoryRepository.findById(recipeCategoryId).orElseThrow(() -> new IllegalArgumentException("Could not find a recipe category with id " + recipeCategoryId));
        recipeCategory.setCategory(recipeCategoryForm.getCategory());
        return recipeCategoryRepository.save(recipeCategory);
    }

    @Override
    public void delete(Integer recipeCategoryId) {
        recipeCategoryRepository.deleteById(recipeCategoryId);
    }

    @Override
    public RecipeCategory addRecipe(Integer recipeCategoryId, Recipe recipe) {
        if (recipe == null) throw new IllegalArgumentException("Recipe was null");
        RecipeCategory recipeCategory = recipeCategoryRepository.findById(recipeCategoryId).orElseThrow(() -> new IllegalArgumentException("Could not find a recipe category with id " + recipeCategoryId));
        recipeCategory.addRecipe(recipe);
        return recipeCategoryRepository.save(recipeCategory);
    }

    @Override
    public RecipeCategory removeRecipe(Integer recipeCategoryId, Recipe recipe) {
        if (recipe == null) throw new IllegalArgumentException("Recipe was null");
        RecipeCategory recipeCategory = recipeCategoryRepository.findById(recipeCategoryId).orElseThrow(() -> new IllegalArgumentException("Could not find a recipe category with id " + recipeCategoryId));
        recipeCategory.removeRecipe(recipe);
        return recipeCategoryRepository.save(recipeCategory);
    }
}
