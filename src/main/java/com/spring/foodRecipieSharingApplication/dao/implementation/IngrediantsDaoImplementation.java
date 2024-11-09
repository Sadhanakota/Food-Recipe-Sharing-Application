package com.spring.foodRecipieSharingApplication.dao.implementation;

import com.spring.foodRecipieSharingApplication.models.entity.Ingrediants;
import com.spring.foodRecipieSharingApplication.repository.IngrediantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.foodRecipieSharingApplication.dao.IngrediantsDao;

import java.util.List;
import java.util.Optional;

@Repository
public class IngrediantsDaoImplementation implements IngrediantsDao {

    @Autowired
   private IngrediantsRepository ingrediantsRepository;

    @Override
    public Ingrediants createIngrediant(Ingrediants ingrediants) {
        return ingrediantsRepository.save(ingrediants);
    }
    @Override
    public Ingrediants findIngrediantById(int id){
        Optional ingrediant=ingrediantsRepository.findById(id);
        if(ingrediant.isPresent())
        {
            return (Ingrediants) ingrediant.get();
        }
        else{
            return null;
        }
    }

    @Override
    public Ingrediants updateIngrediant(Ingrediants ingrediants) {

        return ingrediantsRepository.save(ingrediants);
    }

    @Override
    public String deleteIngredient(Ingrediants ingrediants) {
        ingrediantsRepository.delete(ingrediants);
        return "Ingredient is Deleted";
    }

    @Override
    public List<Ingrediants> getAllIngrediants(){
        return ingrediantsRepository.findAll();
    }
}
