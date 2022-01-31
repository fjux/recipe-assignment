package com.example.recipeassignment.controllers;

import com.example.recipeassignment.model.dto.form.RecipeCategoryForm;
import com.example.recipeassignment.model.dto.view.RecipeCategoryDTO;
import com.example.recipeassignment.model.entity.Recipe;
import com.example.recipeassignment.service.facade.RecipeCategoryService;
import com.example.recipeassignment.validation.OnPost;
import com.example.recipeassignment.validation.OnPut;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeCategoryController {

    private final RecipeCategoryService recipeCategoryService;

    public RecipeCategoryController(RecipeCategoryService recipeCategoryService) {
        this.recipeCategoryService = recipeCategoryService;
    }
    @PostMapping("/api/v1/categories")
    public ResponseEntity<RecipeCategoryDTO> create(@Validated(OnPost.class) @RequestBody RecipeCategoryForm recipeCategoryForm) {
        return ResponseEntity.status(201).body(recipeCategoryService.create(recipeCategoryForm));
    }

    @GetMapping("/api/v1/categories/{id}")
    public ResponseEntity<RecipeCategoryDTO> findById(@PathVariable("id") Integer recipeCategoryId) {
        return ResponseEntity.ok(recipeCategoryService.findById(recipeCategoryId));
    }

    @GetMapping("/api/v1/categories")
    public ResponseEntity<List<RecipeCategoryDTO>> finAll() {
        return ResponseEntity.ok(recipeCategoryService.findAll());
    }

    @PutMapping("/api/v1/categories/{id}")
    public ResponseEntity<RecipeCategoryDTO> update(@PathVariable("id") Integer recipeCategoryId, @Validated(OnPut.class) @RequestBody RecipeCategoryForm recipeCategoryForm) {
        return ResponseEntity.ok(recipeCategoryService.update(recipeCategoryId, recipeCategoryForm));
    }
    @PutMapping("/api/v1/categories/{id}/recipes/add")
    public ResponseEntity<RecipeCategoryDTO> addRecipe(@PathVariable("id") Integer recipeCategoryId, Recipe recipe) {
        return ResponseEntity.ok(recipeCategoryService.addRecipe(recipeCategoryId, recipe));
    }

    @PutMapping("/api/v1/categories/{id}/recipes/remove")
    public ResponseEntity<RecipeCategoryDTO> removeRecipe(@PathVariable("id") Integer recipeCategoryId, Recipe recipe) {
        return ResponseEntity.ok(recipeCategoryService.removeRecipe(recipeCategoryId, recipe));
    }
}
