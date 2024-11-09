package com.spring.foodRecipieSharingApplication.service.implementation;

import com.spring.foodRecipieSharingApplication.dao.IngrediantsDao;
import com.spring.foodRecipieSharingApplication.exception.DataNotFoundException;
import com.spring.foodRecipieSharingApplication.models.dto.IngrediantsDto;
import com.spring.foodRecipieSharingApplication.models.dto.ResponseStructure;
import com.spring.foodRecipieSharingApplication.models.entity.Ingrediants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.foodRecipieSharingApplication.service.IngrediantService;

import java.security.interfaces.RSAKey;
import java.util.List;

@Service
public class IngrediantsServiceImplementation implements IngrediantService {

    @Autowired
    IngrediantsDao ingrediantsDao;
    @Override
    public ResponseEntity<ResponseStructure<Ingrediants>> createIngrediant(IngrediantsDto ingrediantsDto) {
        Ingrediants ingrediants=new Ingrediants();
        ingrediants.setIngrediantsName(ingrediantsDto.getIngrediantsName());
        ingrediants.setIngrediantsPrice(ingrediantsDto.getIngrediantsPrice());
        ingrediants.setQuantity(ingrediantsDto.getQuantity());

        ResponseStructure<Ingrediants> responseStructure=new ResponseStructure<>();
        responseStructure.setData(ingrediantsDao.createIngrediant(ingrediants));
        responseStructure.setMessage("Ingredient Created Successfully");
        responseStructure.setStatusCode(HttpStatus.CREATED.value());
        return new ResponseEntity<>(responseStructure,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseStructure<Ingrediants>> findIngrediantById(int id) {
        Ingrediants ingrediants=ingrediantsDao.findIngrediantById(id);
        if(ingrediants!=null)
        {
            ResponseStructure<Ingrediants> responseStructure=new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.FOUND.value());
            responseStructure.setMessage("Ingredient is fetched successfully");
            responseStructure.setData(ingrediants);
            return new ResponseEntity<>(responseStructure,HttpStatus.FOUND);
        }
        else{
            throw new DataNotFoundException("Ingrediant is not found");
        }
    }

    @Override
    public ResponseEntity<ResponseStructure<Ingrediants>> updateIngrediant(int id,IngrediantsDto ingrediantsDto) {

        Ingrediants ingrediants=ingrediantsDao.findIngrediantById(id);
        if(ingrediants!=null)
        {
           String ingrediantName= ingrediantsDto.getIngrediantsName();
            if(ingrediantName!=null)
            {
                ingrediants.setIngrediantsName(ingrediantName);
            }
           double ingrediantPrice= ingrediantsDto.getIngrediantsPrice();
            if(ingrediantPrice!=0.0)
            {
                ingrediants.setIngrediantsPrice(ingrediantPrice);
            }
            double quantity=ingrediantsDto.getQuantity();
            if(quantity!=0.0){
                ingrediants.setQuantity(quantity);
            }
            Ingrediants updatedIngrediants=ingrediantsDao.updateIngrediant(ingrediants);
            ResponseStructure<Ingrediants> responseStructure=new ResponseStructure<>();
            responseStructure.setData(ingrediantsDao.createIngrediant(updatedIngrediants));
            responseStructure.setMessage("Ingredient updated Successfully");
            responseStructure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(responseStructure,HttpStatus.OK);
        }
        else {
            throw new DataNotFoundException("Ingrediant is not found to update");
        }
    }

    @Override
    public ResponseEntity<ResponseStructure<String>> deleteIngredient(int id) {
        Ingrediants ingrediants=ingrediantsDao.findIngrediantById(id);
        if(ingrediants!=null)
        {
            String message=ingrediantsDao.deleteIngredient(ingrediants);
            ResponseStructure<String> responseStructure=new ResponseStructure<>();
            responseStructure.setData(message);
            responseStructure.setMessage("Deleted Successfully");
            responseStructure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(responseStructure,HttpStatus.OK);
        }
        else {
            throw new DataNotFoundException("Ingrediant is not found to delete");
        }
    }

    @Override
    public ResponseEntity<ResponseStructure<List<Ingrediants>>> getAllIngrediants() {
        List<Ingrediants> ingrediantsList= ingrediantsDao.getAllIngrediants();
        if(!ingrediantsList.isEmpty())
        {
            ResponseStructure<List<Ingrediants>> responseStructure=new ResponseStructure<>();
            responseStructure.setData(ingrediantsList);
            responseStructure.setMessage("All ingredients fetched successfully");
            responseStructure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(responseStructure,HttpStatus.OK);
        }
        else {

            ResponseStructure<List<Ingrediants>> responseStructure=new ResponseStructure<>();
            responseStructure.setData(ingrediantsList);
            responseStructure.setMessage("Ingredients are not Present");
            responseStructure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(responseStructure,HttpStatus.OK);
        }

    }
}
