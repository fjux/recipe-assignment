package com.example.recipeassignment.service.facade;

import com.example.recipeassignment.model.dto.view.*;
import com.example.recipeassignment.model.entity.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Transactional
public class EntityToDTOConverter implements DTOService{


    @Override
    public IngredientDTO toIngredientDTO(Ingredient ingredient) {
        if (ingredient == null) throw new IllegalArgumentException("Ingredient was null");
        IngredientDTO ingredientDTO = new IngredientDTO();
        ingredientDTO.setIngredientId(ingredient.getIngredientId());
        ingredientDTO.setIngredientName(ingredient.getIngredientName());
        return ingredientDTO;
    }

    @Override
    public RecipeInstructionDTO toRecipeInstructionDTO(RecipeInstruction recipeInstruction) {
        if (recipeInstruction == null) return null;
        RecipeInstructionDTO recipeInstructionDTO = new RecipeInstructionDTO();
        recipeInstructionDTO.setId(recipeInstruction.getId());
        recipeInstructionDTO.setInstruction(recipeInstruction.getInstructions());
        return recipeInstructionDTO;
    }

    @Override
    public RecipeIngredientDTO toSmallRecipeIngredientDTO(RecipeIngredient recipeIngredient) {
        if (recipeIngredient == null) return null;
        RecipeIngredientDTO recipeIngredientDTO = new RecipeIngredientDTO();
        recipeIngredientDTO.setRecipeIngredientId(recipeIngredient.getRecipeIngredientId());
        recipeIngredientDTO.setAmount(recipeIngredient.getAmount());
        recipeIngredientDTO.setMeasurement(recipeIngredient.getMeasurement());
        return recipeIngredientDTO;
    }

    @Override
    public RecipeIngredientDTO toFullRecipeIngredientDTO(RecipeIngredient recipeIngredient) {
        if (recipeIngredient == null) return null;
        RecipeIngredientDTO recipeIngredientDTO = toSmallRecipeIngredientDTO(recipeIngredient);
        recipeIngredientDTO.setIngredient(toIngredientDTO(recipeIngredient.getIngredient()));
        recipeIngredientDTO.setRecipe(toSmallRecipeDTO(recipeIngredient.getRecipe()));
        return recipeIngredientDTO;
    }

    @Override
    public RecipeCategoryDTO toSmallRecipeCategoryDTO(RecipeCategory recipeCategory) {
        if (recipeCategory == null) return null;
        RecipeCategoryDTO recipeCategoryDTO = new RecipeCategoryDTO();
        recipeCategoryDTO.setRecipeCategoryId(recipeCategory.getRecipeCategoryId());
        recipeCategoryDTO.setCategory(recipeCategory.getCategory());
        return recipeCategoryDTO;
    }

    @Override
    public RecipeCategoryDTO toFullRecipeCategoryDTO(RecipeCategory recipeCategory) {
        if (recipeCategory == null) return null;
        RecipeCategoryDTO recipeCategoryDTO = toSmallRecipeCategoryDTO(recipeCategory);
        Set<RecipeDTO> recipeDTOS = new HashSet<>();
        if (!recipeCategory.getRecipes().isEmpty()){
            recipeDTOS = recipeCategory.getRecipes().stream()
                    .map(this::toSmallRecipeDTO)
                    .collect(Collectors.toSet());
        }
        recipeCategoryDTO.setRecipeDTOS(recipeDTOS);
        return recipeCategoryDTO;
    }

    @Override
    public RecipeDTO toSmallRecipeDTO(Recipe recipe) {
        if (recipe == null) return null;
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setRecipeId(recipe.getRecipeId());
        recipeDTO.setRecipeName(recipe.getRecipeName());
        return recipeDTO;
    }

    @Override
    public RecipeDTO toFullRecipeDTO(Recipe recipe) {
        if (recipe == null) return null;
        RecipeDTO recipeDTO = toSmallRecipeDTO(recipe);
        recipeDTO.setRecipeInstructionDto(toRecipeInstructionDTO(recipe.getInstruction()));
        Set<RecipeCategoryDTO> recipeCategoryDTOS = new HashSet<>();
        if (!recipe.getCategories().isEmpty()){
            recipeCategoryDTOS = recipe.getCategories().stream()
                    .map(this::toSmallRecipeCategoryDTO)
                    .collect(Collectors.toSet());
        }
        recipeDTO.setRecipeCategoryDtos(recipeCategoryDTOS);

        Set<RecipeIngredientDTO> recipeIngredientDTOS = new HashSet<>();
        if (!recipe.getIngredients().isEmpty()){
            recipeIngredientDTOS = recipe.getIngredients().stream()
                    .map(this::toSmallRecipeIngredientDTO)
                    .collect(Collectors.toSet());
        }
        recipeDTO.setRecipeIngredientDtos(recipeIngredientDTOS);
        return recipeDTO;
    }

    @Override
    public AppUserDTO toFullAppUserDTO(AppUser appUser) {
        if(appUser == null) return null;
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setAppUserDTOId(appUser.getUserId());
        appUserDTO.setUsername(appUser.getUsername());
        appUserDTO.setRoles(
                appUser.getRoles().stream()
                        .map(AppRole::getUserRole)
                        .collect(Collectors.toList())
        );
        return appUserDTO;
    }
}
