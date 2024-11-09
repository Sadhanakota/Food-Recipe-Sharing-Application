package com.spring.foodRecipieSharingApplication.service;

import com.spring.foodRecipieSharingApplication.models.dto.IngrediantsDto;
import com.spring.foodRecipieSharingApplication.models.dto.RecipeDto;
import com.spring.foodRecipieSharingApplication.models.dto.ResponseStructure;
import com.spring.foodRecipieSharingApplication.models.entity.Recipe;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RecipeService {
    ResponseEntity<ResponseStructure<Recipe>> createRecipe(RecipeDto recipeDto, IngrediantsDto ingrediantsDto,int id);
    ResponseEntity<ResponseStructure<Recipe>> findRecipeById(int id);
    ResponseEntity<ResponseStructure<Recipe>> updateRecipe(RecipeDto recipeDto,int id);
    ResponseEntity<ResponseStructure<List<Recipe>>> getAllRecipe();




}
