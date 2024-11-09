package com.spring.foodRecipieSharingApplication.dao.implementation;

import com.spring.foodRecipieSharingApplication.dao.RecipeDao;
import com.spring.foodRecipieSharingApplication.models.entity.Recipe;
import com.spring.foodRecipieSharingApplication.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RecipeDaoImplementation implements RecipeDao {

    @Autowired
    private  RecipeRepository recipeRepository;


    @Override
    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe findRecipeById(int id) {
        Optional recipe=recipeRepository.findById(id);
        if(recipe.isPresent()){
            return(Recipe) recipe.get();
        }
       else{
           return null;
        }
    }

    @Override
    public Recipe updateRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public String deleteRecipe(Recipe recipe) {
        recipeRepository.delete(recipe);
        return "Recipe is deleted";
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
}
