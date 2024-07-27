package com.graphql.graphql.repositories;

import com.graphql.graphql.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}
