package com.spring.foodRecipieSharingApplication.service;

import com.spring.foodRecipieSharingApplication.models.dto.ResponseStructure;
import com.spring.foodRecipieSharingApplication.models.dto.UserDto;
import com.spring.foodRecipieSharingApplication.models.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

public ResponseEntity<ResponseStructure<User>> createUser(UserDto userDto);
}
