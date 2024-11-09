package com.spring.foodRecipieSharingApplication.service.implementation;

import com.spring.foodRecipieSharingApplication.dao.RecipeDao;
import com.spring.foodRecipieSharingApplication.dao.UserDao;
import com.spring.foodRecipieSharingApplication.exception.DataNotFoundException;
import com.spring.foodRecipieSharingApplication.models.dto.IngrediantsDto;
import com.spring.foodRecipieSharingApplication.models.dto.RecipeDto;
import com.spring.foodRecipieSharingApplication.models.dto.ResponseStructure;
import com.spring.foodRecipieSharingApplication.models.entity.Ingrediants;
import com.spring.foodRecipieSharingApplication.models.entity.Recipe;
import com.spring.foodRecipieSharingApplication.models.entity.User;
import com.spring.foodRecipieSharingApplication.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RecipeServiceImplementation  implements RecipeService {
    @Autowired
    private RecipeDao recipeDao;
    @Autowired
    private UserDao userDao;


    @Override
    public ResponseEntity<ResponseStructure<Recipe>> createRecipe(RecipeDto recipeDto, IngrediantsDto ingrediantsDto, int id) {
        User user= userDao.findUserById(id);
        if(user!=null) {
            Recipe recipe = new Recipe();
            recipe.setTitle(recipeDto.getTitle());
            recipe.setDescription(recipeDto.getDescription());
            recipe.setCreateDate(recipeDto.getCreateDate());
            Ingrediants ingrediants = new Ingrediants();
            ingrediants.setIngrediantsName(ingrediantsDto.getIngrediantsName());
            ingrediants.setIngrediantsPrice(ingrediantsDto.getIngrediantsPrice());
            ingrediants.setQuantity(ingrediantsDto.getQuantity());
            List<Ingrediants> ingrediantsList= new ArrayList<>();
            recipe.setIngrediants(ingrediantsList);
            Recipe createRecipe = recipeDao.createRecipe(recipe);
            List<Recipe> recipeList=user.getRecipeList();
            recipeList.add(createRecipe);
            user.setRecipeList(recipeList);
            userDao.updateUser(user);
            ResponseStructure<Recipe> responseStructure = new ResponseStructure<>();
            responseStructure.setData(createRecipe);
            responseStructure.setMessage("Recipe Created Successfully");
            responseStructure.setStatusCode(HttpStatus.CREATED.value());
            return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
        }else{
            throw new DataNotFoundException("User not found to add a recipe");
        }
    }

    @Override
    public ResponseEntity<ResponseStructure<Recipe>> findRecipeById(int id) {
        Recipe foundRecipe = recipeDao.findRecipeById(id);
        if (foundRecipe != null) {
            ResponseStructure<Recipe> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.FOUND.value());
            responseStructure.setMessage("Recipe is fetched successfully");
            responseStructure.setData(foundRecipe);
            return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
        } else {
            throw new DataNotFoundException("Recipe is not found");
        }
    }




    @Override
    public ResponseEntity<ResponseStructure<Recipe>> updateRecipe(RecipeDto recipeDto,int id) {
        Recipe recipe = recipeDao.findRecipeById(id);
        if (recipe != null) {
            String title = recipeDto.getTitle();
            if (title != null) {
                recipe.setTitle(title);
            }
            String description = recipeDto.getDescription();
            if (description != null) {
                recipe.setDescription(description);
            }
            Date createDate = recipeDto.getCreateDate();
            if (createDate != null) {
                recipe.setCreateDate(createDate);
            }
            Recipe updatedRecipe = recipeDao.updateRecipe(recipe);
            ResponseStructure<Recipe> responseStructure = new ResponseStructure<>();
            responseStructure.setData(updatedRecipe);
            responseStructure.setMessage("Recipe updated Successfully");
            responseStructure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        } else {
            throw new DataNotFoundException("Recipe is not found to update");
        }


    }



    @Override
    public ResponseEntity<ResponseStructure<List<Recipe>>> getAllRecipe() {
        List<Recipe> recipeList= recipeDao.getAllRecipes();
        if(!recipeList.isEmpty())
        {
            ResponseStructure<List<Recipe>> responseStructure=new ResponseStructure<>();
            responseStructure.setData(recipeList);
            responseStructure.setMessage("All recipe fetched successfully");
            responseStructure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(responseStructure,HttpStatus.OK);
        }
        else {

            ResponseStructure<List<Recipe>> responseStructure=new ResponseStructure<>();
            responseStructure.setData(new ArrayList<>());
            responseStructure.setMessage("Recipes are not Present");
            responseStructure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(responseStructure,HttpStatus.OK);
        }


    }
}

