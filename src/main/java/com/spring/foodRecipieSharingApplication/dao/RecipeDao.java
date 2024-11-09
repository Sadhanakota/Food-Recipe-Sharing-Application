package com.spring.foodRecipieSharingApplication.dao;

import com.spring.foodRecipieSharingApplication.models.entity.Recipe;

import java.util.List;

public interface RecipeDao {

    Recipe createRecipe(Recipe recipe);
    Recipe findRecipeById(int id);
    Recipe updateRecipe(Recipe recipe);
    String deleteRecipe(Recipe recipe);
    List<Recipe> getAllRecipes();

}
