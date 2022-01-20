package com.example.recipeassignment.service.entity;

import com.example.recipeassignment.data.IngredientRepository;
import com.example.recipeassignment.model.dto.form.IngredientForm;
import com.example.recipeassignment.model.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class IngredientEntityServiceImpl implements IngredientEntityService {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientEntityServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient create(IngredientForm ingredientForm) {
        if (ingredientForm == null) throw new IllegalArgumentException("Ingredient Form was null");
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName(ingredientForm.getIngredientName());
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient findById(Integer ingredientId) {
        return ingredientRepository.findById(ingredientId).orElseThrow(() -> new IllegalArgumentException("Could not find an ingredient with id " + ingredientId));
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient update(Integer ingredientId, IngredientForm ingredientForm) {
        if (ingredientForm == null) throw new IllegalArgumentException("Ingredient Form " + ingredientForm + " was null");
        Ingredient ingredient = ingredientRepository.findById(ingredientId).orElseThrow(() -> new IllegalArgumentException("Could not find an ingredient with id " + ingredientId));
        ingredient.setIngredientName(ingredientForm.getIngredientName());
        return ingredientRepository.save(ingredient);
    }

    @Override
    public void delete(Integer ingredientId) {
        ingredientRepository.deleteById(ingredientId);
    }


    @Override
    public Optional<Ingredient> findByIngredientName(String ingredientName) {
        return ingredientRepository.findByIngredientNameIgnoreCase(ingredientName);
    }

    @Override
    public List<Ingredient> findAllByIngredientNameContains(String ingredientName) {
        return ingredientRepository.findByIngredientNameContains(ingredientName);
    }
}
