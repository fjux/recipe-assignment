package com.example.recipeassignment.model.dto.form;

import com.example.recipeassignment.validation.OnPut;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

import static com.example.recipeassignment.validation.messages.ValidationMessages.MANDATORY_FIELD;

public class RecipeInstructionForm implements Serializable {

    @NotBlank(message = MANDATORY_FIELD, groups = OnPut.class)
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
