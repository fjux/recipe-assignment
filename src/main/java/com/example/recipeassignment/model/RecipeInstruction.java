package com.example.recipeassignment.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static com.example.recipeassignment.model.constants.EntityConstants.GENERATOR;
import static com.example.recipeassignment.model.constants.EntityConstants.UUID_GENERATOR;


@Entity
public class RecipeInstruction {
    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name =GENERATOR, strategy = UUID_GENERATOR)
    @Column(updatable = false)
    private String id;
    private String instructions;

    public RecipeInstruction(String instructions) {
        this.instructions = instructions;
    }

    public RecipeInstruction() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
