package com.example.recipeassignment.service.facade;

import com.example.recipeassignment.model.dto.form.RecipeCategoryForm;
import com.example.recipeassignment.model.dto.view.RecipeCategoryDTO;
import com.example.recipeassignment.model.dto.view.RecipeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class RecipeCategoryServiceImpl implements RecipeCategoryService{

    private final RecipeCategoryService recipeCategoryService;
    private final DTOService dtoService;

    @Autowired
    public RecipeCategoryServiceImpl(RecipeCategoryService recipeCategoryService, DTOService dtoService) {
        this.recipeCategoryService = recipeCategoryService;
        this.dtoService = dtoService;
    }

    @Override
    public RecipeCategoryDTO create(RecipeCategoryForm recipeCategoryForm) {
        return null;
    }

    @Override
    public RecipeCategoryDTO findById(Integer Id) {
        return null;
    }

    @Override
    public List<RecipeCategoryDTO> findAll() {
        return null;
    }

    @Override
    public RecipeCategoryDTO update(Integer integer, RecipeCategoryForm recipeCategoryForm) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public RecipeCategoryDTO addRecipe(Integer recipeCategoryId, RecipeDTO recipe) {
        return null;
    }

    @Override
    public RecipeCategoryDTO removeRecipe(Integer recipeCategoryId, RecipeDTO recipe) {
        return null;
    }
}
