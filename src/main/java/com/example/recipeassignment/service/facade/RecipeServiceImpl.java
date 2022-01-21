package com.example.recipeassignment.service.facade;

import com.example.recipeassignment.model.dto.form.RecipeForm;
import com.example.recipeassignment.model.dto.view.RecipeDTO;
import com.example.recipeassignment.model.entity.RecipeCategory;
import com.example.recipeassignment.model.entity.RecipeIngredient;
import com.example.recipeassignment.service.entity.RecipeEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
        return dtoService.toFullRecipeDTO(recipeEntityService.create(recipeForm));
    }

    @Override
    public RecipeDTO findById(Integer recipeId) {
        return dtoService.toSmallRecipeDTO(recipeEntityService.findById(recipeId));
    }

    @Override
    public List<RecipeDTO> findAll() {
        return recipeEntityService.findAll().stream()
                .map(dtoService::toSmallRecipeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDTO update(Integer recipeId, RecipeForm recipeForm) {
        return dtoService.toFullRecipeDTO(recipeEntityService.update(recipeId, recipeForm));
    }

    @Override
    public void delete(Integer recipeId) {
        recipeEntityService.delete(recipeId);
    }

    @Override
    public List<RecipeDTO> findByRecipeNameContains(String recipeName) {
        return recipeEntityService.findByRecipeNameContains(recipeName).stream()
                .map(dtoService::toSmallRecipeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecipeDTO> findByIngredientName(String ingredientName) {
        return recipeEntityService.findByIngredientName(ingredientName).stream()
                .map(dtoService::toSmallRecipeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecipeDTO> findByCategory(String category) {
        return recipeEntityService.findByCategory(category).stream()
                .map(dtoService::toSmallRecipeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecipeDTO> findByCategories(String... categories) {
        return recipeEntityService.findByCategories(categories).stream()
                .map(dtoService::toSmallRecipeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDTO addRecipeIngredient(Integer recipeId, RecipeIngredient recipeIngredient) {
        return dtoService.toFullRecipeDTO(recipeEntityService.addRecipeIngredient(recipeId, recipeIngredient));
    }

    @Override
    public RecipeDTO removeRecipeIngredient(Integer recipeId, RecipeIngredient recipeIngredient) {
        return dtoService.toFullRecipeDTO(recipeEntityService.removeRecipeIngredient(recipeId, recipeIngredient));
    }

    @Override
    public RecipeDTO addRecipeCategory(Integer recipeId, RecipeCategory recipeCategory) {
        return dtoService.toFullRecipeDTO(recipeEntityService.addRecipeCategory(recipeId, recipeCategory));
    }

    @Override
    public RecipeDTO removeRecipeCategory(Integer recipeId, RecipeCategory recipeCategory) {
        return dtoService.toFullRecipeDTO(recipeEntityService.removeRecipeCategory(recipeId, recipeCategory));
    }
}
