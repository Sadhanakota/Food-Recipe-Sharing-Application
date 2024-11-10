package com.spring.foodRecipieSharingApplication.service.implementation;

import com.spring.foodRecipieSharingApplication.dao.UserDao;
import com.spring.foodRecipieSharingApplication.exception.DataNotFoundException;
import com.spring.foodRecipieSharingApplication.models.dto.ResponseStructure;
import com.spring.foodRecipieSharingApplication.models.dto.UserDto;
import com.spring.foodRecipieSharingApplication.models.entity.User;
import com.spring.foodRecipieSharingApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserDao userDao;
//Create
    @Override
    public ResponseEntity<ResponseStructure<User>> createUser(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setUserEmail(userDto.getUserEmail());
        user.setUserPlace(userDto.getUserPlace());

        ResponseStructure<User>responseStructure=new ResponseStructure<>();
        responseStructure.setData(userDao.createUser(user));
        responseStructure.setStatusCode(HttpStatus.CREATED.value());
        responseStructure.setMessage("Successfully added user details");
        return new ResponseEntity<>(responseStructure,HttpStatus.CREATED);

    }


    //Find
    @Override
    public ResponseEntity<ResponseStructure<User>> findUserById(int id) {
        ResponseStructure<User> responseStructure = new ResponseStructure<User>();
        User user = userDao.findUserById(id);
        if (user != null) {
            responseStructure.setData(user);
            responseStructure.setMessage("User found successfully");
            responseStructure.setStatusCode(HttpStatus.FOUND.value());
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        }
        else {
            throw new DataNotFoundException("User not found");
        }

    }
//Update
    @Override
    public ResponseEntity<ResponseStructure<User>> updateUser(int id,UserDto userDto) {
        ResponseStructure<User> responseStructure = new ResponseStructure<User>();
        User existingUser = userDao.findUserById(id);
        if (existingUser != null) {

            if (userDto.getUserName() != null) {
                existingUser.setUserName(userDto.getUserName());
            }
            if (userDto.getUserEmail() != null) {
                existingUser.setUserEmail(userDto.getUserEmail());
            }
            if (userDto.getUserPlace() != null) {
                existingUser.setUserPlace(userDto.getUserPlace());
            }

            // Save the updated user
            User updatedUser = userDao.updateUser(existingUser);


            responseStructure.setData(updatedUser);
            responseStructure.setMessage("User updated successfully");
            responseStructure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        } else {
            throw new DataNotFoundException("User not found");
        }
    }
    //Delete
    @Override
    public ResponseEntity<ResponseStructure<String>> deleteUser(int id) {
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        User existingUser = userDao.findUserById(id);

        if (existingUser != null) {
        String deleteUser = userDao.deleteUser(existingUser);

            responseStructure.setData(deleteUser);
            responseStructure.setMessage("Deleted successfully");
            responseStructure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        } else {
            throw new DataNotFoundException("User not found");
        }

    }

    //FindAll
    @Override
    public ResponseEntity<ResponseStructure<List<User>>> getAllUsers() {
        List<User> userList = userDao.getAllUser();

        ResponseStructure<List<User>> responseStructure = new ResponseStructure<>();
        if (userList != null && !userList.isEmpty()) {
            responseStructure.setData(userList);
            responseStructure.setMessage("Users retrieved successfully");
            responseStructure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        } else {
            responseStructure.setData(new ArrayList<>());
            responseStructure.setMessage("No users found");
            responseStructure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        }
    }








}
