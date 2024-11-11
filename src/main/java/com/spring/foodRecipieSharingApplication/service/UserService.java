package com.spring.foodRecipieSharingApplication.service;

import com.spring.foodRecipieSharingApplication.models.dto.RecipeDto;
import com.spring.foodRecipieSharingApplication.models.dto.ResponseStructure;
import com.spring.foodRecipieSharingApplication.models.dto.UserDto;
import com.spring.foodRecipieSharingApplication.models.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
//Save
public ResponseEntity<ResponseStructure<User>> createUser(UserDto userDto);

    //Find
   public ResponseEntity<ResponseStructure<User>> findUserById(int id);

   //Update
    public ResponseEntity<ResponseStructure<User>> updateUser(int id,UserDto userDto);

    //Delete
    ResponseEntity<ResponseStructure<String>> deleteUser(int id);

    //FindAll
    ResponseEntity<ResponseStructure<List<User>>> getAllUsers();

    //AddRecipeToUser
    ResponseEntity<ResponseStructure<User>> addRecipeToUser(int userId, RecipeDto recipeDto);
}
