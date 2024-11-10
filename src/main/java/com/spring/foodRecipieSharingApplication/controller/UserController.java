package com.spring.foodRecipieSharingApplication.controller;

import com.spring.foodRecipieSharingApplication.models.dto.ResponseStructure;
import com.spring.foodRecipieSharingApplication.models.dto.UserDto;
import com.spring.foodRecipieSharingApplication.models.entity.User;
import com.spring.foodRecipieSharingApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //Save
    @PostMapping("/save")
    public ResponseEntity<ResponseStructure<User>> createUser(@RequestBody UserDto userDto)
    {
        return userService.createUser(userDto);
    }

    //Find
    @GetMapping("/findById/id")
    public ResponseEntity<ResponseStructure<User>> findUserById(@PathVariable int id)
    {
        return userService.findUserById(id);
    }

    //Update

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<ResponseStructure<User>> updateUser(@PathVariable int id, @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    //Delete

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    //FindAll

    @GetMapping("/all")
    public ResponseEntity<ResponseStructure<List<User>>> getAllUsers() {
        return userService.getAllUsers();
    }


}
