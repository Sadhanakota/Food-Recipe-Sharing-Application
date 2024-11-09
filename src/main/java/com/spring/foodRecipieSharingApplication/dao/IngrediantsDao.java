package com.spring.foodRecipieSharingApplication.dao;

import com.spring.foodRecipieSharingApplication.models.entity.Ingrediants;

import java.util.List;

public interface IngrediantsDao {

    Ingrediants createIngrediant(Ingrediants ingrediants);
    Ingrediants findIngrediantById(int id);
    Ingrediants updateIngrediant(Ingrediants ingrediants);
    String deleteIngredient(Ingrediants ingrediants);
    List<Ingrediants> getAllIngrediants();
}
