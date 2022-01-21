package com.example.recipeassignment.service.facade;

import com.example.recipeassignment.model.dto.form.RecipeIngredientForm;
import com.example.recipeassignment.model.dto.view.RecipeIngredientDTO;
import com.example.recipeassignment.service.entity.RecipeIngredientEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RecipeIngredientServiceImpl implements RecipeIngredientService{

    private final RecipeIngredientEntityService recipeIngredientEntityService;
    private final DTOService dtoService;

    @Autowired
    public RecipeIngredientServiceImpl(RecipeIngredientEntityService recipeIngredientEntityService, DTOService dtoService) {
        this.recipeIngredientEntityService = recipeIngredientEntityService;
        this.dtoService = dtoService;
    }

    @Override
    public RecipeIngredientDTO create(RecipeIngredientForm recipeIngredientForm) {
        return dtoService.toFullRecipeIngredientDTO(recipeIngredientEntityService.create(recipeIngredientForm));
    }

    @Override
    public RecipeIngredientDTO findById(String recipeIngredientId) {
        return dtoService.toSmallRecipeIngredientDTO(recipeIngredientEntityService.findById(recipeIngredientId));
    }

    @Override
    public List<RecipeIngredientDTO> findAll() {
        return recipeIngredientEntityService.findAll().stream()
                .map(dtoService::toSmallRecipeIngredientDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeIngredientDTO update(String recipeIngredientDTOId, RecipeIngredientForm recipeIngredientForm) {
        return dtoService.toFullRecipeIngredientDTO(recipeIngredientEntityService.update(recipeIngredientDTOId, recipeIngredientForm));
    }

    @Override
    public void delete(String recipeIngredientId) {
       recipeIngredientEntityService.delete(recipeIngredientId);
    }
}
