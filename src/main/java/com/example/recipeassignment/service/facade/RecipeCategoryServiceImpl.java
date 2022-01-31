package com.example.recipeassignment.service.facade;

import com.example.recipeassignment.model.dto.form.RecipeCategoryForm;
import com.example.recipeassignment.model.dto.view.RecipeCategoryDTO;
import com.example.recipeassignment.model.dto.view.RecipeDTO;
import com.example.recipeassignment.model.entity.Recipe;
import com.example.recipeassignment.service.entity.RecipeCategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class RecipeCategoryServiceImpl implements RecipeCategoryService{

    private final RecipeCategoryEntityService recipeCategoryEntityService;
    private final DTOService dtoService;

    @Autowired
    public RecipeCategoryServiceImpl(RecipeCategoryEntityService recipeCategoryEntityService, DTOService dtoService) {
        this.recipeCategoryEntityService = recipeCategoryEntityService;
        this.dtoService = dtoService;
    }

    @Override
    public RecipeCategoryDTO create(RecipeCategoryForm recipeCategoryForm) {
        return dtoService.toFullRecipeCategoryDTO(recipeCategoryEntityService.create(recipeCategoryForm));
    }

    @Override
    public RecipeCategoryDTO findById(Integer recipeCategoryId) {
        return dtoService.toSmallRecipeCategoryDTO(recipeCategoryEntityService.findById(recipeCategoryId));
    }

    @Override
    public List<RecipeCategoryDTO> findAll() {
        return recipeCategoryEntityService.findAll().stream()
                .map(dtoService::toSmallRecipeCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeCategoryDTO update(Integer recipeCategoryId, RecipeCategoryForm recipeCategoryForm) {
        return dtoService.toSmallRecipeCategoryDTO(recipeCategoryEntityService.update(recipeCategoryId, recipeCategoryForm));
    }

    @Override
    public void delete(Integer recipeCategoryId) {
        recipeCategoryEntityService.delete(recipeCategoryId);
    }

    @Override
    public RecipeCategoryDTO findByCategoryIgnoreCase(String category) {
        return dtoService.toSmallRecipeCategoryDTO(recipeCategoryEntityService.findByCategoryIgnoreCase(category));
    }

    @Override
    public RecipeCategoryDTO addRecipe(Integer recipeCategoryId, Recipe recipe) {
        return dtoService.toFullRecipeCategoryDTO(recipeCategoryEntityService.addRecipe(recipeCategoryId, recipe));
    }

    @Override
    public RecipeCategoryDTO removeRecipe(Integer recipeCategoryId, Recipe recipe) {
        return dtoService.toFullRecipeCategoryDTO(recipeCategoryEntityService.removeRecipe(recipeCategoryId, recipe));
    }
}
