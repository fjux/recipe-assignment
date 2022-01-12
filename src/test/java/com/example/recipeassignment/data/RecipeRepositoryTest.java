package com.example.recipeassignment.data;

import com.example.recipeassignment.model.*;
import com.example.recipeassignment.model.constants.Measurement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DataJpaTest
@Transactional
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

    private Ingredient ingredient1 = new Ingredient(INGREDIENT_1);
    private Ingredient ingredient2 = new Ingredient(INGREDIENT_2);
    private Ingredient ingredient3 = new Ingredient(INGREDIENT_3);
    private Ingredient ingredient4 = new Ingredient(INGREDIENT_4);
    private Ingredient ingredient5 = new Ingredient(INGREDIENT_5);
    private Ingredient ingredient6 = new Ingredient(INGREDIENT_6);

    private RecipeInstruction recipeInstruction1, recipeInstruction2, recipeInstruction3;

    private RecipeCategory recipeCategory1, recipeCategory2,recipeCategory3;

    private RecipeIngredient recipeIngredient1, recipeIngredient2, recipeIngredient3, recipeIngredient4, recipeIngredient5, recipeIngredient6, recipeIngredient7, recipeIngredient8;

    private Recipe recipe1, recipe2, recipe3, recipe4;


    @Autowired
    private RecipeRepository testObject;

    @Autowired
    private RecipeIngredientRepository recipeIngredientRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeInstructionRepository recipeInstructionRepository;

    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;



    @BeforeEach
    void setUp() {

        ingredient1 = ingredientRepository.save(ingredient1);
        ingredient2 = ingredientRepository.save(ingredient2);
        ingredient3 = ingredientRepository.save(ingredient3);
        ingredient4 = ingredientRepository.save(ingredient4);
        ingredient5 = ingredientRepository.save(ingredient5);
        ingredient6 = ingredientRepository.save(ingredient6);

        recipeIngredient1 = new RecipeIngredient(ingredient1, 10.0, Measurement.DL,recipe1);
        recipeIngredient2 = new RecipeIngredient(ingredient2, 5.0, Measurement.DL,recipe1);
        recipeIngredient3 = new RecipeIngredient(ingredient3, 150.0, Measurement.G,recipe2);
        recipeIngredient4 = new RecipeIngredient(ingredient4, 1.0, Measurement.DL,recipe2);
        recipeIngredient5 = new RecipeIngredient(ingredient2, 10.0, Measurement.DL,recipe3);
        recipeIngredient6 = new RecipeIngredient(ingredient6, 1.5, Measurement.KG,recipe3);
        recipeIngredient7 = new RecipeIngredient(ingredient1, 5.0, Measurement.DL, recipe4);
        recipeIngredient8 = new RecipeIngredient(ingredient4, 5.0, Measurement.DL, recipe4);
        recipeIngredient1 = recipeIngredientRepository.save(recipeIngredient1);
        recipeIngredient2 = recipeIngredientRepository.save(recipeIngredient2);
        recipeIngredient3 = recipeIngredientRepository.save(recipeIngredient3);
        recipeIngredient4 = recipeIngredientRepository.save(recipeIngredient4);
        recipeIngredient5 = recipeIngredientRepository.save(recipeIngredient5);
        recipeIngredient6 = recipeIngredientRepository.save(recipeIngredient6);
        recipeIngredient7 = recipeIngredientRepository.save(recipeIngredient7);
        recipeIngredient8 = recipeIngredientRepository.save(recipeIngredient8);

        recipeInstruction1 = new RecipeInstruction(INSTRUCTION_1);
        recipeInstruction2 = new RecipeInstruction(INSTRUCTION_2);
        recipeInstruction3 = new RecipeInstruction(INSTRUCTION_3);
        recipeInstruction1 = recipeInstructionRepository.save(recipeInstruction1);
        recipeInstruction2 = recipeInstructionRepository.save(recipeInstruction2);
        recipeInstruction3 = recipeInstructionRepository.save(recipeInstruction3);

        recipe1 = new Recipe("Pancake", recipeInstruction1);
        recipe2 = new Recipe("Miso soup", recipeInstruction2);
        recipe3 = new Recipe("Fish soup", recipeInstruction3);
        recipe4 = new Recipe("Stuffed rabbit", recipeInstruction1);

        recipeCategory1 = new RecipeCategory(CATEGORY_1);
        recipeCategory2 = new RecipeCategory(CATEGORY_2);
        recipeCategory3 = new RecipeCategory(CATEGORY_3);
        recipeCategory1 = recipeCategoryRepository.save(recipeCategory1);
        recipeCategory2 = recipeCategoryRepository.save(recipeCategory2);
        recipeCategory3 = recipeCategoryRepository.save(recipeCategory3);


        recipe1.addRecipeIngredient(recipeIngredient1);
        recipe1.addRecipeIngredient(recipeIngredient2);
        recipe2.addRecipeIngredient(recipeIngredient3);
        recipe2.addRecipeIngredient(recipeIngredient4);
        recipe3.addRecipeIngredient(recipeIngredient5);
        recipe3.addRecipeIngredient(recipeIngredient6);
        recipe4.addRecipeIngredient(recipeIngredient7);
        recipe4.addRecipeIngredient(recipeIngredient8);
        recipe1.addRecipeCategory(recipeCategory1);
        recipe1.addRecipeCategory(recipeCategory2);
        recipe2.addRecipeCategory(recipeCategory3);
        recipe3.addRecipeCategory(recipeCategory3);
        recipe4.addRecipeCategory(recipeCategory2);

        recipe1 = testObject.save(recipe1);
        recipe2 = testObject.save(recipe2);
        recipe3 = testObject.save(recipe3);
        recipe4 = testObject.save(recipe4);



    }



    @Test
    void findByRecipeNameContains() {
        assertEquals(1, testObject.findByRecipeNameContains("Pancake").size());
        assertEquals(3, testObject.findByRecipeNameContains("u").size());

    }

    @Test
    void findByIngredientName() {
        List<Recipe> testList;
        testList = testObject.findByIngredientName("Milk");
        assertEquals(2, testList.size());
    }

    @Test
    void findByCategory() {
        System.out.println(recipeCategory2);
        assertEquals(2, testObject.findByCategory("Meal").size());
    }

    @Test
    void findByCategories() {
        List<Recipe> recipeList;
        recipeList= testObject.findByCategories("Mexican", "Indian", "Meal", "Dessert", "Swedish", "Blood");
        System.out.println(recipeList);
        assertEquals(2, recipeList.size());


    }
}