package com.example.recipeassignment.controllers;


import com.example.recipeassignment.model.dto.form.RecipeForm;
import com.example.recipeassignment.model.dto.view.RecipeDTO;
import com.example.recipeassignment.model.entity.RecipeCategory;
import com.example.recipeassignment.model.entity.RecipeIngredient;
import com.example.recipeassignment.service.facade.RecipeService;
import com.example.recipeassignment.validation.OnPost;
import com.example.recipeassignment.validation.OnPut;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/api/v1/recipes")
    public ResponseEntity<RecipeDTO> create(@Validated(OnPost.class) @RequestBody RecipeForm recipeForm){
        return ResponseEntity.status(201).body(recipeService.create(recipeForm));
    }

    @GetMapping("/api/v1/recipes/{id}")
    public ResponseEntity<RecipeDTO> findById(@PathVariable("id") Integer recipeId){
        return ResponseEntity.ok(recipeService.findById(recipeId));
    }

    @GetMapping("/api/v1/recipes")
    public ResponseEntity<List<RecipeDTO>> findAll(){
        return ResponseEntity.ok(recipeService.findAll());
    }

    @PutMapping("/api/v1/recipes/{id}")
    public ResponseEntity<RecipeDTO> update(@PathVariable("id") Integer recipeId, @Validated(OnPut.class) @RequestBody RecipeForm recipeForm){
        return ResponseEntity.ok(recipeService.update(recipeId, recipeForm));
    }

    @DeleteMapping("/api/v1/recipes/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer recipeId){
        recipeService.delete(recipeId);
            return ResponseEntity.noContent().build();
    }

    @GetMapping("/api/v1/recipes/{name}")
    public ResponseEntity<List<RecipeDTO>> findByNameContains(@PathVariable("name") String recipeName){
        return ResponseEntity.ok(recipeService.findByRecipeNameContains(recipeName));
    }

    @GetMapping("/api/v1/recipes/{ingredient}")
    public ResponseEntity<List<RecipeDTO>> findByIngredientName(@PathVariable("ingredient") String ingredientName){
        return ResponseEntity.ok(recipeService.findByIngredientName(ingredientName));
    }

    @GetMapping("/api/v1/recipes/{category}")
    public ResponseEntity<List<RecipeDTO>> findByCategory(@PathVariable("category") String category){
        return ResponseEntity.ok(recipeService.findByCategory(category));
    }

    @GetMapping("/api/v1/recipes/{categories}")
    public ResponseEntity<List<RecipeDTO>> findByCategories(@PathVariable("categories") String... categories){
        return ResponseEntity.ok(recipeService.findByCategories(categories));
    }

    @PutMapping("/api/v1/recipes/{id}/ingredients/add")
    public ResponseEntity<RecipeDTO> addIngredient(@PathVariable("id") Integer recipeId, RecipeIngredient recipeIngredient){
        return  ResponseEntity.ok(recipeService.addRecipeIngredient(recipeId, recipeIngredient));
    }

    @PutMapping("/api/v1/recipes/{id}/ingredients/remove")
    public ResponseEntity<RecipeDTO> removeIngredient(@PathVariable("id") Integer recipeId, RecipeIngredient recipeIngredient){
        return ResponseEntity.ok(recipeService.removeRecipeIngredient(recipeId, recipeIngredient));
    }

    @PutMapping("/api/v1/recipes/{id}/categories/add")
    public ResponseEntity<RecipeDTO> addCategory(@PathVariable("id") Integer recipeId, RecipeCategory recipeCategory){
        return  ResponseEntity.ok(recipeService.addRecipeCategory(recipeId, recipeCategory));
    }

    @PutMapping("/api/v1/recipes/{id}/categories/remove")
    public ResponseEntity<RecipeDTO> removeCategory(@PathVariable("id") Integer recipeId, RecipeCategory recipeCategory){
        return ResponseEntity.ok(recipeService.removeRecipeCategory(recipeId, recipeCategory));
    }
}
