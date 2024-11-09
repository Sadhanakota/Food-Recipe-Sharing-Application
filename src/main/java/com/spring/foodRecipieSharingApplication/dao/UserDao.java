package com.spring.foodRecipieSharingApplication.dao;

import com.spring.foodRecipieSharingApplication.models.entity.User;

import java.util.List;

public interface UserDao {

    User createUser(User user);
    User findUserById(int id);
    User updateUser(User user);
    String deleteUser(User user);
    List<User> getAllUser();
}
