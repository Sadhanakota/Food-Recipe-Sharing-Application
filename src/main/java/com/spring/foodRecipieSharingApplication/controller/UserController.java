package com.spring.foodRecipieSharingApplication.controller;

import com.spring.foodRecipieSharingApplication.models.dto.ResponseStructure;
import com.spring.foodRecipieSharingApplication.models.dto.UserDto;
import com.spring.foodRecipieSharingApplication.models.entity.User;
import com.spring.foodRecipieSharingApplication.service.RecipeService;
import com.spring.foodRecipieSharingApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class  UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<ResponseStructure<User>> createUser(@RequestBody UserDto userDto)
    {
        return userService.createUser(userDto);
    }

}
