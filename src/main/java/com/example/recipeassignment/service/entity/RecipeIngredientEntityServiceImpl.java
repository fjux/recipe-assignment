package com.example.recipeassignment.service.entity;

import com.example.recipeassignment.data.RecipeIngredientRepository;
import com.example.recipeassignment.model.dto.form.RecipeIngredientForm;
import com.example.recipeassignment.model.entity.RecipeIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class RecipeIngredientEntityServiceImpl implements RecipeIngredientEntityService{

    private final RecipeIngredientRepository recipeIngredientRepository;

    private final IngredientEntityService ingredientEntityService;

    private final RecipeEntityService recipeEntityService;

    @Autowired
    public RecipeIngredientEntityServiceImpl(RecipeIngredientRepository recipeIngredientRepository, IngredientEntityService ingredientEntityService, RecipeEntityService recipeEntityService) {
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.ingredientEntityService = ingredientEntityService;
        this.recipeEntityService = recipeEntityService;
    }

    @Override
    public RecipeIngredient create(RecipeIngredientForm recipeIngredientForm) {
        if (recipeIngredientForm == null) throw new IllegalArgumentException("The Recipe ingredient form was null");
        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setIngredient(ingredientEntityService.create(recipeIngredientForm.getIngredient()));
        recipeIngredient.setAmount(recipeIngredientForm.getAmount());
        recipeIngredient.setMeasurement(recipeIngredientForm.getMeasurement());
        recipeIngredient.setRecipe(recipeEntityService.create(recipeIngredientForm.getRecipe()));
        return recipeIngredientRepository.save(recipeIngredient);
    }

    @Override
    public RecipeIngredient findById(String recipeIngredientId) {
        return recipeIngredientRepository.findById(recipeIngredientId).orElseThrow(() -> new IllegalArgumentException("Could not find a recipe ingredient with id " + recipeIngredientId));
    }

    @Override
    public List<RecipeIngredient> findAll() {
        return recipeIngredientRepository.findAll();
    }

    @Override
    public RecipeIngredient update(String recipeIngredientId, RecipeIngredientForm recipeIngredientForm) {
        if (recipeIngredientForm == null) throw new IllegalArgumentException("Recipe ingredient form was null");
        RecipeIngredient recipeIngredient = recipeIngredientRepository.findById(recipeIngredientId).orElseThrow(() -> new IllegalArgumentException("Could not find a recipe ingredient with id " + recipeIngredientId));
        recipeIngredient.setAmount(recipeIngredientForm.getAmount());
        recipeIngredient.setMeasurement(recipeIngredientForm.getMeasurement());
        return recipeIngredientRepository.save(recipeIngredient);
    }

    @Override
    public void delete(String recipeIngredientId) {
        recipeIngredientRepository.deleteById(recipeIngredientId);
    }
}
