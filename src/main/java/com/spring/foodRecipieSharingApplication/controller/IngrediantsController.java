package com.spring.foodRecipieSharingApplication.controller;


import com.spring.foodRecipieSharingApplication.models.dto.IngrediantsDto;
import com.spring.foodRecipieSharingApplication.models.dto.ResponseStructure;
import com.spring.foodRecipieSharingApplication.models.entity.Ingrediants;
import com.spring.foodRecipieSharingApplication.service.IngrediantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingrediant")
public class IngrediantsController {

    @Autowired
    private IngrediantService ingrediantsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseStructure<Ingrediants>> createIngrediant(@RequestBody IngrediantsDto ingrediantsDto){
    return ingrediantsService.createIngrediant(ingrediantsDto);
    }

    @GetMapping("/find/{id}")
   public ResponseEntity<ResponseStructure<Ingrediants>> findIngrediantById(@PathVariable int id){
        return ingrediantsService.findIngrediantById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseStructure<Ingrediants>> updateIngrediant(@PathVariable int id,@RequestBody IngrediantsDto ingrediantsDto){
        return ingrediantsService.updateIngrediant(id,ingrediantsDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteIngredient(@PathVariable int id){

        return ingrediantsService.deleteIngredient(id);
    }

    @GetMapping("/getAll/Ingredients")
    public ResponseEntity<ResponseStructure<List<Ingrediants>>>  getAllIngrediants(){
        return ingrediantsService.getAllIngrediants();
    }
}
