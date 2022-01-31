package com.example.recipeassignment.controllers;


import com.example.recipeassignment.model.dto.form.RecipeIngredientForm;
import com.example.recipeassignment.model.dto.view.RecipeIngredientDTO;
import com.example.recipeassignment.service.facade.RecipeIngredientService;
import com.example.recipeassignment.validation.OnPost;
import com.example.recipeassignment.validation.OnPut;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeIngredientController {

    private final RecipeIngredientService recipeIngredientService;

    public RecipeIngredientController(RecipeIngredientService recipeIngredientService) {
        this.recipeIngredientService = recipeIngredientService;
    }
    @PostMapping("/api/v1/recipeingredients")
    public ResponseEntity<RecipeIngredientDTO> create(@Validated(OnPost.class) @RequestBody RecipeIngredientForm recipeIngredientForm) {
        return ResponseEntity.status(201).body(recipeIngredientService.create(recipeIngredientForm));
    }

    @GetMapping("/api/v1/recipeingredients")
    public ResponseEntity<List<RecipeIngredientDTO>> findAll(){
        return ResponseEntity.ok(recipeIngredientService.findAll());
    }

    @GetMapping("/api/v1/recipeingredients/{id}")
    public ResponseEntity<RecipeIngredientDTO> findById(@PathVariable("id") String recipeIngredientId, @RequestBody RecipeIngredientForm recipeIngredientForm) {
        return ResponseEntity.ok(recipeIngredientService.findById(recipeIngredientId));
    }

    @PutMapping("/api/v1/recipeingredients/{id}")
    public ResponseEntity<RecipeIngredientDTO> update(@PathVariable("id") String recipeIngredientId, @Validated(OnPut.class) @RequestBody RecipeIngredientForm recipeIngredientForm) {
        return ResponseEntity.ok(recipeIngredientService.update(recipeIngredientId, recipeIngredientForm));
    }

    @DeleteMapping("/api/v1/recipeingredients/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String recipeIngredientId){
        recipeIngredientService.delete(recipeIngredientId);
        return ResponseEntity.noContent().build();
    }
}
