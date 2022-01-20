package com.example.recipeassignment.service.facade;

import com.example.recipeassignment.model.dto.form.RecipeInstructionForm;
import com.example.recipeassignment.model.dto.view.RecipeInstructionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class RecipeInstructionServiceImpl implements RecipeInstructionService{

    private final RecipeInstructionService recipeInstructionService;
    private final DTOService dtoService;

    @Autowired
    public RecipeInstructionServiceImpl(RecipeInstructionService recipeInstructionService, DTOService dtoService) {
        this.recipeInstructionService = recipeInstructionService;
        this.dtoService = dtoService;
    }

    @Override
    public RecipeInstructionDTO create(RecipeInstructionForm recipeInstructionForm) {
        return null;
    }

    @Override
    public RecipeInstructionDTO findById(String Id) {
        return null;
    }

    @Override
    public List<RecipeInstructionDTO> findAll() {
        return null;
    }

    @Override
    public RecipeInstructionDTO update(String s, RecipeInstructionForm recipeInstructionForm) {
        return null;
    }

    @Override
    public void delete(String s) {

    }
}
