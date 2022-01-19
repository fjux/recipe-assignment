package com.example.recipeassignment.model.dto.form;

import java.io.Serializable;

public class RecipeInstructionForm implements Serializable {
    private String id;
    private String instruction;

    public RecipeInstructionForm() {
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
