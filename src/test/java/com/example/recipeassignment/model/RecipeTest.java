package com.example.recipeassignment.model;

import com.example.recipeassignment.data.IngredientRepository;
import com.example.recipeassignment.data.RecipeCategoryRepository;
import com.example.recipeassignment.data.RecipeIngredientRepository;
import com.example.recipeassignment.data.RecipeRepository;
import com.example.recipeassignment.model.constants.Measurement;
import com.example.recipeassignment.model.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@Transactional
class RecipeTest {

    Ingredient falukorv = new Ingredient("Falukorv");
    Ingredient gulLok = new Ingredient("Gul lök");
    RecipeInstruction instruction = new RecipeInstruction("Hacka, stek ät");
    RecipeCategory recipeCategory1 = new RecipeCategory("Husman");
    Recipe korvStroganoff = new Recipe("Korv Stroganoff", instruction);
    RecipeIngredient recipeIngredient1 = new RecipeIngredient(falukorv, 2.0, Measurement.HG, null);
    RecipeIngredient recipeIngredient2 = new RecipeIngredient(gulLok, 2.0, Measurement.HG, null);

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private RecipeIngredientRepository recipeIngredientRepository;
    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;
    @Autowired
    private IngredientRepository ingredientRepository;

    @BeforeEach
    void setUp() {

       recipeRepository.save(korvStroganoff);
       korvStroganoff.getCategories();
       korvStroganoff.getIngredients();
       ingredientRepository.save(falukorv);
       ingredientRepository.save(gulLok);
       recipeIngredientRepository.save(recipeIngredient1);
       recipeIngredientRepository.save(recipeIngredient2);
       recipeCategoryRepository.save(recipeCategory1);




    }

    @Test
    void addRecipeCategory() {

        assertNotNull(korvStroganoff);
        korvStroganoff.addRecipeCategory(recipeCategory1);
        assertEquals(true, korvStroganoff.getCategories().contains(recipeCategory1));


    }

    @Test
    void removeRecipeCategory() {
        korvStroganoff.addRecipeCategory(recipeCategory1);
        assertEquals(true, korvStroganoff.getCategories().contains(recipeCategory1));
        korvStroganoff.removeRecipeCategory(recipeCategory1);
        assertEquals(false, korvStroganoff.getCategories().contains(recipeCategory1));
    }

    @Test
    void addRecipeIngredient() {
        korvStroganoff.addRecipeIngredient(recipeIngredient1);
        korvStroganoff.addRecipeIngredient(recipeIngredient2);
        assertEquals(true, korvStroganoff.getIngredients().contains(recipeIngredient1));
        assertEquals(true, korvStroganoff.getIngredients().contains(recipeIngredient2));
    }

    @Test
    void removeRecipeIngredient() {
        korvStroganoff.addRecipeIngredient(recipeIngredient1);
        assertEquals(true, korvStroganoff.getIngredients().contains(recipeIngredient1));
        korvStroganoff.removeRecipeIngredient(recipeIngredient1);
        assertEquals(false, korvStroganoff.getIngredients().contains(recipeIngredient1));
    }
}