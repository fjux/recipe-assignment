package com.example.recipeassignment.controllers;

import com.example.recipeassignment.model.dto.form.RecipeInstructionForm;
import com.example.recipeassignment.model.dto.view.RecipeInstructionDTO;
import com.example.recipeassignment.service.facade.RecipeInstructionService;
import com.example.recipeassignment.validation.OnPost;
import com.example.recipeassignment.validation.OnPut;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeInstructionController {

    private final RecipeInstructionService recipeInstructionService;

    public RecipeInstructionController(RecipeInstructionService recipeInstructionService) {
        this.recipeInstructionService = recipeInstructionService;
    }

    @PostMapping("/api/v1/instructions")
    public ResponseEntity<RecipeInstructionDTO> create(@Validated(OnPost.class) @RequestBody RecipeInstructionForm recipeInstructionForm){
        return ResponseEntity.status(201).body(recipeInstructionService.create(recipeInstructionForm));
    }

    @GetMapping("/api/v1/instructions/{id}")
    public ResponseEntity<RecipeInstructionDTO> findById(@PathVariable("id") String recipeInstructionId){
        return ResponseEntity.ok(recipeInstructionService.findById(recipeInstructionId));
    }
    @GetMapping("/api/v1/instructions")
    public ResponseEntity<List<RecipeInstructionDTO>> finAll(){
        return ResponseEntity.ok(recipeInstructionService.findAll());
    }

    @PutMapping("/api/v1/instructions/{id}")
    public ResponseEntity<RecipeInstructionDTO> update(@PathVariable("id") String recipeInstructionId, @Validated(OnPut.class) @RequestBody RecipeInstructionForm recipeInstructionForm){
        return ResponseEntity.ok(recipeInstructionService.update(recipeInstructionId, recipeInstructionForm));
    }

    @DeleteMapping("/api/v1/instructions/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String recipeInstructionId) {
        recipeInstructionService.delete(recipeInstructionId);
        return ResponseEntity.noContent().build();
    }
}
