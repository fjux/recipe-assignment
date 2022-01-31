package com.example.recipeassignment.model.dto.form;

import com.example.recipeassignment.validation.OnPost;
import com.example.recipeassignment.validation.OnPut;
import com.example.recipeassignment.validation.UniqueCategory;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

import static com.example.recipeassignment.validation.messages.ValidationMessages.MANDATORY_FIELD;
import static com.example.recipeassignment.validation.messages.ValidationMessages.UNIQUE_CATEGORY;

public class RecipeCategoryForm implements Serializable {

    @NotBlank(message = MANDATORY_FIELD, groups = OnPut.class)
    private int recipeCategoryId;
    @NotBlank(message = MANDATORY_FIELD, groups = {OnPost.class, OnPut.class})
    @UniqueCategory(message = UNIQUE_CATEGORY, groups = OnPost.class)
    private String category;

    public RecipeCategoryForm() {
    }

    public int getRecipeCategoryId() {
        return recipeCategoryId;
    }

    public void setRecipeCategoryId(int recipeCategoryId) {
        this.recipeCategoryId = recipeCategoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
