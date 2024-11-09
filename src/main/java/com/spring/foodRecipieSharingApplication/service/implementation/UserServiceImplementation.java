package com.spring.foodRecipieSharingApplication.service.implementation;

import com.spring.foodRecipieSharingApplication.dao.UserDao;
import com.spring.foodRecipieSharingApplication.models.dto.ResponseStructure;
import com.spring.foodRecipieSharingApplication.models.dto.UserDto;
import com.spring.foodRecipieSharingApplication.models.entity.User;
import com.spring.foodRecipieSharingApplication.service.RecipeService;
import com.spring.foodRecipieSharingApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserDao userDao;

    //Create
    public ResponseEntity<ResponseStructure<User>> createUser(UserDto userDto)
    {
        User user = new User();
        user.setUserName(userDto.getUserName());
        ResponseStructure<User>responseStructure=new ResponseStructure<>();
        responseStructure.setData(userDao.createUser(user));
        responseStructure.setMessage("OK");
        responseStructure.setStatusCode(HttpStatus.CREATED.value());
        return new ResponseEntity<>(responseStructure,HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity<RecipeService> creatUser(UserDto user) {
        return null;
    }
}
