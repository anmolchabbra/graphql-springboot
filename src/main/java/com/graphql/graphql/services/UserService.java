package com.graphql.graphql.services;

import com.graphql.graphql.entities.User;
import com.graphql.graphql.helper.ExceptionHelper;
import com.graphql.graphql.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    //creating user
    public User createUser(User user) {
        return userRepo.save(user);
    }
    //getting all users
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    //getting single user
    public User getSingleUser(int userId) {
        User user = userRepo.findById(userId).orElseThrow(ExceptionHelper :: throwResourceNotFoundException);
        return user;
    }
    
    //updating user
    public User updateUser(int userId, User user) {
        User toChange = userRepo.findById(userId).orElseThrow(ExceptionHelper :: throwResourceNotFoundException);
        toChange.setName(user.getName());
        toChange.setEmail(user.getEmail());
        toChange.setPassword(user.getPassword());
        toChange.setOrders(user.getOrders());
        toChange.setPhone(user.getPhone());
        return userRepo.save(toChange);
    }
    
    
    //deleting user
    public boolean deleteUser(int userID) {
        User user = userRepo.findById(userID).orElseThrow(ExceptionHelper :: throwResourceNotFoundException);
        userRepo.delete(user);
        return true;
    }
    
}
