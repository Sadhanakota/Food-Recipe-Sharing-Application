package com.spring.foodRecipieSharingApplication.dao.implementation;

import com.spring.foodRecipieSharingApplication.dao.UserDao;
import com.spring.foodRecipieSharingApplication.models.entity.User;
import com.spring.foodRecipieSharingApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImplementation implements UserDao {
@Autowired
   private UserRepository userRepository;


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
