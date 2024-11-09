package com.spring.foodRecipieSharingApplication.service;

import com.spring.foodRecipieSharingApplication.models.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

ResponseEntity<RecipeService> creatUser(UserDto user);
}
