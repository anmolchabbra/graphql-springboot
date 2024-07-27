package com.graphql.graphql.services;

import com.graphql.graphql.entities.Order;
import com.graphql.graphql.helper.ExceptionHelper;
import com.graphql.graphql.repositories.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }
    
    //create Order
    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }
    
    //get all orders
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
    
    //get single order
    public Order getOrder(int orderId) {
        Order order = orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        return order;
    }
    
    //delete order
    public boolean deleteOrder(int orderId) {
        Order order = orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        orderRepo.delete(order);
        return true;
    }
    
    
}
