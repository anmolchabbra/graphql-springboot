package com.graphql.graphql.controllers;

import com.graphql.graphql.entities.Order;
import com.graphql.graphql.entities.User;
import com.graphql.graphql.services.OrderService;
import com.graphql.graphql.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class OrderController {

    private OrderService orderService;
    private UserService userService;

    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    // Create order
    @MutationMapping(name = "createOrder")
    public Order createOrder(@Argument String orderDetail, @Argument String address, @Argument int price, @Argument int userId) {
        User user = userService.getSingleUser(userId);
        Order order = new Order();
        order.setOrderDetail(orderDetail);
        order.setPrice(price);
        order.setAddress(address);
        order.setUser(user);
        orderService.createOrder(order);
        return order;
    }

    // Delete order
    @MutationMapping(name = "deleteOrder")
    public boolean deleteOrder(@Argument int orderId) {
        return orderService.deleteOrder(orderId);
    }

    // Get all orders
    @QueryMapping(name = "getOrders")
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    // Get single order
    @QueryMapping(name = "getOrder")
    public Order getOrder(@Argument int orderId) {
        return orderService.getOrder(orderId);
    }
}
