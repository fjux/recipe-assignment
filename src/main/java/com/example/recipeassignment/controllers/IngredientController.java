package com.example.recipeassignment.controllers;

import com.example.recipeassignment.model.dto.form.IngredientForm;
import com.example.recipeassignment.model.dto.view.IngredientDTO;
import com.example.recipeassignment.service.facade.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {

    private final IngredientService ingredientService;


    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;

    }
    @PostMapping("/api/v1/ingredients")
    public ResponseEntity<IngredientDTO> create(@RequestBody IngredientForm ingredientForm) {
        return ResponseEntity.status(201).body(ingredientService.create(ingredientForm));
    }

    @GetMapping("/api/v1/ingredients")
    public ResponseEntity<List<IngredientDTO>> findAll() {
        return ResponseEntity.ok(ingredientService.findAll());
    }

    @GetMapping("/api/v1/ingredients/{id}")
    public ResponseEntity<IngredientDTO> findById(@PathVariable("id") Integer ingredientId){
        return ResponseEntity.ok(ingredientService.findById(ingredientId));
    }

    @PutMapping("/api/v1/ingredients/{id}")
    public ResponseEntity<IngredientDTO> update( @PathVariable("id") Integer ingredientId, @RequestBody IngredientForm ingredientForm) {
        return ResponseEntity.ok(ingredientService.update(ingredientId, ingredientForm));
    }

    @DeleteMapping("/api/v1/ingredients/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer ingredientId){
        ingredientService.delete(ingredientId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/api/v1/ingredients/{name}")
    public ResponseEntity<IngredientDTO> findByName(@PathVariable("name") String ingredientName){
        return ResponseEntity.ok(ingredientService.findByIngredientNameIgnoreCase(ingredientName));
    }

    @GetMapping("/api/v1/ingredients/{name}")
    public ResponseEntity<List<IngredientDTO>> findByNameContains(@PathVariable("name") String ingredientName){
        return ResponseEntity.ok(ingredientService.findByIngredientNameContains(ingredientName));
    }



}
