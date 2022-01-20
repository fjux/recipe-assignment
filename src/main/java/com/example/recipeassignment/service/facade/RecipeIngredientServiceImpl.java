package com.example.recipeassignment.service.facade;

import com.example.recipeassignment.model.dto.form.RecipeIngredientForm;
import com.example.recipeassignment.model.dto.view.RecipeIngredientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecipeIngredientServiceImpl implements RecipeIngredientService{

    private final RecipeIngredientService recipeIngredientService;
    private final DTOService dtoService;

    @Autowired
    public RecipeIngredientServiceImpl(RecipeIngredientService recipeIngredientService, DTOService dtoService) {
        this.recipeIngredientService = recipeIngredientService;
        this.dtoService = dtoService;
    }

    @Override
    public RecipeIngredientDTO create(RecipeIngredientForm recipeIngredientForm) {
        return null;
    }

    @Override
    public RecipeIngredientDTO findById(String Id) {
        return null;
    }

    @Override
    public List<RecipeIngredientDTO> findAll() {
        return null;
    }

    @Override
    public RecipeIngredientDTO update(String s, RecipeIngredientForm recipeIngredientForm) {
        return null;
    }

    @Override
    public void delete(String s) {

    }
}
