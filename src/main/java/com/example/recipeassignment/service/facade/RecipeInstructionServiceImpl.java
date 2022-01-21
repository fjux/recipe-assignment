package com.example.recipeassignment.service.facade;

import com.example.recipeassignment.model.dto.form.RecipeInstructionForm;
import com.example.recipeassignment.model.dto.view.RecipeInstructionDTO;
import com.example.recipeassignment.service.entity.RecipeInstructionEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class RecipeInstructionServiceImpl implements RecipeInstructionService{

    private final RecipeInstructionEntityService recipeInstructionEntityService;
    private final DTOService dtoService;

    @Autowired
    public RecipeInstructionServiceImpl(RecipeInstructionEntityService recipeInstructionEntityService, DTOService dtoService) {
        this.recipeInstructionEntityService = recipeInstructionEntityService;
        this.dtoService = dtoService;
    }

    @Override
    public RecipeInstructionDTO create(RecipeInstructionForm recipeInstructionForm) {
        return dtoService.toRecipeInstructionDTO(recipeInstructionEntityService.create(recipeInstructionForm));
    }

    @Override
    public RecipeInstructionDTO findById(String recipeInstructionId) {
        return dtoService.toRecipeInstructionDTO(recipeInstructionEntityService.findById(recipeInstructionId));
    }

    @Override
    public List<RecipeInstructionDTO> findAll() {
        return recipeInstructionEntityService.findAll().stream()
                .map(dtoService::toRecipeInstructionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeInstructionDTO update(String recipeInstructionId, RecipeInstructionForm recipeInstructionForm) {
        return dtoService.toRecipeInstructionDTO(recipeInstructionEntityService.update(recipeInstructionId, recipeInstructionForm));
    }

    @Override
    public void delete(String recipeInstructionId) {
        recipeInstructionEntityService.delete(recipeInstructionId);
    }
}
