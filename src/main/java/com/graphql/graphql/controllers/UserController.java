package com.graphql.graphql.controllers;

import com.graphql.graphql.entities.User;
import com.graphql.graphql.entities.Order; // Import the Order entity
import com.graphql.graphql.services.UserService;
import com.graphql.graphql.services.OrderService; // Import the OrderService
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class UserController {
    private UserService userService;
   

    public UserController(UserService userService, OrderService orderService) {
        this.userService = userService;
    }

    // Create user
    @MutationMapping(name = "createUser")
    public User createUser(@Argument String name, @Argument String phone, @Argument String email, @Argument String password) {
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        return userService.createUser(user);
    }

    // Get all users
    @QueryMapping(name = "getUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get single user
    @QueryMapping(name = "getUser")
    public User getUser(@Argument int userId) {
        return userService.getSingleUser(userId);
    }

    // Delete user
    @MutationMapping(name = "deleteUser")
    public boolean deleteUser(@Argument int userId) {
        return userService.deleteUser(userId);
    }

    
}
