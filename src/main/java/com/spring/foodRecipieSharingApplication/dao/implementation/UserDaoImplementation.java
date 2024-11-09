package com.spring.foodRecipieSharingApplication.dao.implementation;

import com.spring.foodRecipieSharingApplication.dao.UserDao;
import com.spring.foodRecipieSharingApplication.models.entity.User;
import com.spring.foodRecipieSharingApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImplementation implements UserDao {
@Autowired
   private UserRepository userRepository;


    @Override
    public User createUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public User findUserById(int id) {
        Optional user=userRepository.findById(id);
        if (user.isPresent())
        {
            return (User) user.get();
        }
        else
        {
            return  null;
        }
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(User user) {
        userRepository.delete(user);
        return "User is Deleted Successfully";
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
