package com.spring.foodRecipieSharingApplication.service;

import com.spring.foodRecipieSharingApplication.models.dto.IngrediantsDto;
import com.spring.foodRecipieSharingApplication.models.dto.ResponseStructure;
import com.spring.foodRecipieSharingApplication.models.entity.Ingrediants;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IngrediantService {

 ResponseEntity<ResponseStructure<Ingrediants>> createIngrediant(IngrediantsDto ingrediantsDto);
 ResponseEntity<ResponseStructure<Ingrediants>> findIngrediantById(int id);
 ResponseEntity<ResponseStructure<Ingrediants>> updateIngrediant(int id,IngrediantsDto ingrediantsDto);
 ResponseEntity<ResponseStructure<String>> deleteIngredient(int id);
 ResponseEntity<ResponseStructure<List<Ingrediants>>>  getAllIngrediants();
}
