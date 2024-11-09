package com.spring.foodRecipieSharingApplication.controller;

import com.spring.foodRecipieSharingApplication.models.dto.IngrediantsDto;
import com.spring.foodRecipieSharingApplication.models.dto.RecipeDto;
import com.spring.foodRecipieSharingApplication.models.dto.ResponseStructure;
import com.spring.foodRecipieSharingApplication.models.entity.Recipe;
import com.spring.foodRecipieSharingApplication.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/recipe")
@RestController
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @PostMapping("/save/{id}")
   public ResponseEntity<ResponseStructure<Recipe>> saveRecipe(@RequestBody RecipeDto recipeDto, @RequestBody IngrediantsDto ingrediantsDto, @PathVariable int userId){
       return  recipeService.createRecipe(recipeDto,ingrediantsDto,userId);
    }
  @PutMapping ("/update/{id}")
    public ResponseEntity<ResponseStructure<Recipe>> updateRecipe(@RequestBody RecipeDto recipeDto, @PathVariable int id){
        return recipeService.updateRecipe(recipeDto, id);
}
@GetMapping("/fetch/{id}")
    public ResponseEntity<ResponseStructure<Recipe>> findRecipeById(@PathVariable int id){
        return recipeService.findRecipeById(id);
}
@GetMapping("/getall")
    public ResponseEntity<ResponseStructure<List<Recipe>>> getAllRecipe(){
        return recipeService.getAllRecipe();
}

}
