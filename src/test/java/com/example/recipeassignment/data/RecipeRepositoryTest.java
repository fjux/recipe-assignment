package com.example.recipeassignment.data;

import com.example.recipeassignment.model.*;
import com.example.recipeassignment.model.constants.Measurement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest

class RecipeRepositoryTest {

    private static final String INGREDIENT_1 = "Milk";
    private static final String INGREDIENT_2 = "Flour";
    private static final String INGREDIENT_3 = "Butter";
    private static final String INGREDIENT_4 = "Cream";
    private static final String INGREDIENT_5 = "Miso";
    private static final String INGREDIENT_6 = "Flounder";

    private static final String CATEGORY_1 = "Dessert";
    private static final String CATEGORY_2 = "Meal";
    private static final String CATEGORY_3 = "Soup";

    private static final String INSTRUCTION_1 = "Make a pancake";
    private static final String INSTRUCTION_2 = "Chop vegetables and throw into boiling water";
    private static final String INSTRUCTION_3 = "Make a dough and put into oven";

    private RecipeInstruction recipeInstruction1, recipeInstruction2, recipeInstruction3;

    private Ingredient ingredient1, ingredient2, ingredient3, ingredient4, ingredient5, ingredient6;

    private RecipeCategory recipeCategory1, recipeCategory2,recipeCategory3;

    private RecipeIngredient recipeIngredient1, recipeIngredient2, recipeIngredient3, recipeIngredient4, recipeIngredient5, recipeIngredient6;

    private Recipe recipe1, recipe2, recipe3, recipe4, recipe5;

    private Set<RecipeCategory> categories1 = new HashSet<>();
    private Set<RecipeCategory> categories2 = new HashSet<>();
    private Set<RecipeCategory> categories3 = new HashSet<>();
    private Set<RecipeIngredient> ingredients1 = new HashSet<>();
    private Set<RecipeIngredient> ingredients2 = new HashSet<>();
    private Set<RecipeIngredient> ingredients3 = new HashSet<>();
    private Set<RecipeIngredient> ingredients4 = new HashSet<>();
    private Set<Recipe> recipes = new HashSet<>();
    private Set<Recipe> recipes1 = new HashSet<>();
    private Set<Recipe> recipes2 = new HashSet<>();

    @Autowired
    private RecipeRepository testObject;

    @Autowired
    private RecipeIngredientRepository recipeIngredientRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeInstructionRepository recipeInstructionRepository;



    @BeforeEach
    void setUp() {
        ingredient1 = new Ingredient(INGREDIENT_1);
        ingredient2 = new Ingredient(INGREDIENT_2);
        ingredient3 = new Ingredient(INGREDIENT_3);
        ingredient4 = new Ingredient(INGREDIENT_4);
        ingredient5 = new Ingredient(INGREDIENT_5);
        ingredient6 = new Ingredient(INGREDIENT_6);
        ingredient1 = ingredientRepository.save(ingredient1);
        ingredient3 = ingredientRepository.save(ingredient2);
        ingredient2 = ingredientRepository.save(ingredient3);
        ingredient4 = ingredientRepository.save(ingredient4);
        ingredient5 = ingredientRepository.save(ingredient5);
        ingredient6 = ingredientRepository.save(ingredient6);

        recipeIngredient1 = new RecipeIngredient(ingredient1, 10.0, Measurement.DL,recipe1);
        recipeIngredient2 = new RecipeIngredient(ingredient2, 5.0, Measurement.DL,recipe2);
        recipeIngredient3 = new RecipeIngredient(ingredient3, 150.0, Measurement.G,recipe3);
        recipeIngredient4 = new RecipeIngredient(ingredient4, 1.0, Measurement.DL,recipe4);
        recipeIngredient5 = new RecipeIngredient(ingredient5, 10.0, Measurement.DL,recipe5);
        recipeIngredient6 = new RecipeIngredient(ingredient6, 1.5, Measurement.KG,recipe1);
        recipeIngredient1 = recipeIngredientRepository.save(recipeIngredient1);
        recipeIngredient2 = recipeIngredientRepository.save(recipeIngredient2);
        recipeIngredient3 = recipeIngredientRepository.save(recipeIngredient3);
        recipeIngredient4 = recipeIngredientRepository.save(recipeIngredient4);
        recipeIngredient5 = recipeIngredientRepository.save(recipeIngredient5);
        recipeIngredient6 = recipeIngredientRepository.save(recipeIngredient6);
        ingredients1.add(recipeIngredient1);
        ingredients1.add(recipeIngredient2);
        ingredients2.add(recipeIngredient3);
        ingredients2.add(recipeIngredient4);
        ingredients3.add(recipeIngredient5);
        ingredients3.add(recipeIngredient6);
        ingredients4.add(recipeIngredient1);
        ingredients4.add(recipeIngredient6);

        recipeInstruction1 = new RecipeInstruction(INSTRUCTION_1);
        recipeInstruction2 = new RecipeInstruction(INSTRUCTION_2);
        recipeInstruction3 = new RecipeInstruction(INSTRUCTION_3);
        recipeInstruction1 = recipeInstructionRepository.save(recipeInstruction1);
        recipeInstruction2 = recipeInstructionRepository.save(recipeInstruction2);
        recipeInstruction3 = recipeInstructionRepository.save(recipeInstruction3);

        recipeCategory1 = new RecipeCategory(CATEGORY_1, recipes);
        recipeCategory2 = new RecipeCategory(CATEGORY_2, recipes1);
        recipeCategory3 = new RecipeCategory(CATEGORY_3, recipes2);
        categories1.add(recipeCategory1);
        categories1.add(recipeCategory2);
        categories2.add(recipeCategory3);
        categories2.add(recipeCategory1);
        categories3.add(recipeCategory3);
        categories3.add(recipeCategory2);

        recipe1 = new Recipe("Pancake",ingredients1, recipeInstruction1, categories1);
        recipe2 = new Recipe("Miso soup",ingredients2, recipeInstruction2, categories2);
        recipe3 = new Recipe("Fish soup",ingredients3, recipeInstruction3, categories3);
        recipe4 = new Recipe("Stuffed rabbit",ingredients4, recipeInstruction1, categories2);
        recipe5 = new Recipe("Burning beef",ingredients2, recipeInstruction3, categories1);
        recipe1 = testObject.save(recipe1);
        recipe2 = testObject.save(recipe2);
        recipe3 = testObject.save(recipe3);
        recipe4 = testObject.save(recipe4);
        recipe5 = testObject.save(recipe5);
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe5);
        recipes1.add(recipe2);
        recipes1.add(recipe3);
        recipes1.add(recipe4);
        recipes2.add(recipe5);
        recipes2.add(recipe4);
        recipes2.add(recipe1);


    }

    @Test
    void findByRecipeNameContains() {
        assertEquals(2, testObject.findByRecipeNameContains("SoUp").size());
        assertEquals(4, testObject.findByRecipeNameContains("U").size());
    }

    @Test
    void findByIngredientName() {
        assertEquals(2, testObject.findByIngredientName(INGREDIENT_6));
    }

    @Test
    void findByCategory() {
        ;
    }

    @Test
    void findByCategories() {
    }
}