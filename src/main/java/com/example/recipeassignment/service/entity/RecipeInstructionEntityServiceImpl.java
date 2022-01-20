package com.example.recipeassignment.service.entity;

import com.example.recipeassignment.data.RecipeInstructionRepository;
import com.example.recipeassignment.model.dto.form.RecipeInstructionForm;
import com.example.recipeassignment.model.entity.RecipeInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class RecipeInstructionEntityServiceImpl implements RecipeInstructionEntityService{
    private final RecipeInstructionRepository recipeInstructionRepository;

    @Autowired
    public RecipeInstructionEntityServiceImpl(RecipeInstructionRepository recipeInstructionRepository) {
        this.recipeInstructionRepository = recipeInstructionRepository;
    }

    @Override
    public RecipeInstruction create(RecipeInstructionForm recipeInstructionForm) {
        if (recipeInstructionForm == null) throw new IllegalArgumentException("Recipe instruction form was null");
        RecipeInstruction recipeInstruction = new RecipeInstruction();
        recipeInstruction.setInstructions(recipeInstructionForm.getInstruction());
        return recipeInstructionRepository.save(recipeInstruction);
    }

    @Override
    public RecipeInstruction findById(String recipeInstructionId) {
        return recipeInstructionRepository.findById(recipeInstructionId).orElseThrow(()-> new IllegalArgumentException("Could not find a recipe instruction with id " + recipeInstructionId));
    }

    @Override
    public List<RecipeInstruction> findAll() {
        return recipeInstructionRepository.findAll();
    }

    @Override
    public RecipeInstruction update(String recipeInstructionId, RecipeInstructionForm recipeInstructionForm) {
        if (recipeInstructionForm == null) throw new IllegalArgumentException("Recipe instruction form was null");
        RecipeInstruction recipeInstruction = recipeInstructionRepository.findById(recipeInstructionId).orElseThrow(() -> new IllegalArgumentException("Could not find a recipe instruction with id " + recipeInstructionId));
        recipeInstruction.setInstructions(recipeInstructionForm.getInstruction());
        return recipeInstructionRepository.save(recipeInstruction);
    }

    @Override
    public void delete(String recipeInstructionId) {
        recipeInstructionRepository.deleteById(recipeInstructionId);
    }
}
