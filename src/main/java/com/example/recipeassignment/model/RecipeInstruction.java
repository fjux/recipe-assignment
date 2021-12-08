package com.example.recipeassignment.model;

public class RecipeInstruction {
    private String id;
    private String instructions;

    public RecipeInstruction(String id, String instructions) {
        this.id = id;
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
