package com.example.recipeassignment.service.facade;

import com.example.recipeassignment.model.dto.form.IngredientForm;
import com.example.recipeassignment.model.dto.view.IngredientDTO;
import com.example.recipeassignment.service.entity.IngredientEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class IngredientServiceImpl implements IngredientService{

    private final IngredientEntityService ingredientEntityService;
    private final DTOService dtoService;

    @Autowired
    public IngredientServiceImpl(IngredientEntityService ingredientEntityService, DTOService dtoService) {
        this.ingredientEntityService = ingredientEntityService;
        this.dtoService = dtoService;
    }

    @Override
    public IngredientDTO create(IngredientForm ingredientForm) {
        return dtoService.toIngredientDTO(ingredientEntityService.create(ingredientForm));
    }

    @Override
    public IngredientDTO findById(Integer ingredientId) {
        return dtoService.toIngredientDTO(ingredientEntityService.findById(ingredientId));
    }

    @Override
    public List<IngredientDTO> findAll() {
        return ingredientEntityService.findAll().stream()
                .map(dtoService::toIngredientDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IngredientDTO update(Integer ingredientId, IngredientForm ingredientForm) {
        return dtoService.toIngredientDTO(ingredientEntityService.update(ingredientId, ingredientForm));
    }

    @Override
    public void delete(Integer ingredientId) {
        ingredientEntityService.delete(ingredientId);
    }

    @Override
    public IngredientDTO findByIngredientNameIgnoreCase(String ingredientName) {
        return dtoService.toIngredientDTO(ingredientEntityService.findByIngredientNameIgnoreCase(ingredientName).orElseThrow(() -> new IllegalArgumentException("Could not find an ingredient with name " + ingredientName)));
    }

    @Override
    public List<IngredientDTO> findByIngredientNameContains(String ingredientName) {
        return ingredientEntityService.findAllByIngredientNameContains(ingredientName).stream()
                .map(dtoService::toIngredientDTO)
                .collect(Collectors.toList());
    }
}
