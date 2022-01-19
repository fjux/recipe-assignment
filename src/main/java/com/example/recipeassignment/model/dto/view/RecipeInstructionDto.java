package com.example.recipeassignment.model.dto.view;

import java.io.Serializable;

public class RecipeInstructionDto implements Serializable {
    private String id;
    private String instruction;

    public RecipeInstructionDto(String id, String instruction) {
        this.id = id;
        this.instruction = instruction;
    }

    public RecipeInstructionDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
