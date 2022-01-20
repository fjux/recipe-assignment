package com.example.recipeassignment.service.facade;

import com.example.recipeassignment.model.dto.form.RecipeForm;
import com.example.recipeassignment.model.dto.view.RecipeCategoryDTO;
import com.example.recipeassignment.model.dto.view.RecipeDTO;
import com.example.recipeassignment.model.dto.view.RecipeIngredientDTO;
import com.example.recipeassignment.service.entity.RecipeEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class RecipeServiceImpl implements RecipeService{

    private final RecipeEntityService recipeEntityService;
    private final DTOService dtoService;

    @Autowired
    public RecipeServiceImpl(RecipeEntityService recipeEntityService, DTOService dtoService) {
        this.recipeEntityService = recipeEntityService;
        this.dtoService = dtoService;
    }

    @Override
    public RecipeDTO create(RecipeForm recipeForm) {
        return null;
    }

    @Override
    public RecipeDTO findById(Integer Id) {
        return null;
    }

    @Override
    public List<RecipeDTO> findAll() {
        return null;
    }

    @Override
    public RecipeDTO update(Integer integer, RecipeForm recipeForm) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<RecipeDTO> findByRecipeNameContains(String recipeName) {
        return null;
    }

    @Override
    public List<RecipeDTO> findByIngredientName(String ingredientName) {
        return null;
    }

    @Override
    public List<RecipeDTO> findByCategory(String category) {
        return null;
    }

    @Override
    public List<RecipeDTO> findByCategories(String... categories) {
        return null;
    }

    @Override
    public RecipeDTO addRecipeIngredient(Integer recipeId, RecipeIngredientDTO recipeIngredient) {
        return null;
    }

    @Override
    public RecipeDTO removeRecipeIngredient(Integer recipeId, RecipeIngredientDTO recipeIngredient) {
        return null;
    }

    @Override
    public RecipeDTO addRecipeCategory(Integer recipeId, RecipeCategoryDTO recipeCategory) {
        return null;
    }

    @Override
    public RecipeDTO removeRecipeCategory(Integer recipeId, RecipeCategoryDTO recipeCategory) {
        return null;
    }
}
