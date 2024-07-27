package com.graphql.graphql.repositories;

import com.graphql.graphql.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    //custom queries
    //custom finder methods
    
}
