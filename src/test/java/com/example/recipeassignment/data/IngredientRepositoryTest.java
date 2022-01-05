package com.example.recipeassignment.data;

import com.example.recipeassignment.model.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest

class IngredientRepositoryTest {
    private static final String INGREDIENT_1 = "Milk";
    private static final String INGREDIENT_2 = "Flour";
    private static final String INGREDIENT_3 = "Butter";
    private static final String INGREDIENT_4 = "Cream";
    private static final String INGREDIENT_5 = "Miso";
    private static final String INGREDIENT_6 = "Flounder";
    @Autowired
    private IngredientRepository testObject;
    @Autowired
    private TestEntityManager em;


    private Ingredient ingredient1 = new Ingredient(INGREDIENT_1);
    private Ingredient ingredient2 = new Ingredient(INGREDIENT_2);
    private Ingredient ingredient3 = new Ingredient(INGREDIENT_3);
    private Ingredient ingredient4 = new Ingredient(INGREDIENT_4);
    private Ingredient ingredient5 = new Ingredient(INGREDIENT_5);
    private Ingredient ingredient6 = new Ingredient(INGREDIENT_6);


    @BeforeEach
    void setUp() {
        testObject.save(ingredient1);
        testObject.save(ingredient2);
        testObject.save(ingredient3);
        testObject.save(ingredient4);
        testObject.save(ingredient5);
        testObject.save(ingredient6);
    }

    @Test
    void findByIngredientNameIgnoreCase() {
        assertEquals(INGREDIENT_1, testObject.findByIngredientNameIgnoreCase(INGREDIENT_1).get().getIngredientName());
        assertEquals(INGREDIENT_2, testObject.findByIngredientNameIgnoreCase(INGREDIENT_2.toUpperCase()).get().getIngredientName());
        assertEquals(INGREDIENT_5, testObject.findByIngredientNameIgnoreCase(INGREDIENT_5).get().getIngredientName());
    }

    @Test
    void findByIngredientNameContains() {
    }
}