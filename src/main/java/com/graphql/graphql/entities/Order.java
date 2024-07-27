package com.graphql.graphql.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.type.filter.AbstractClassTestingTypeFilter;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private String orderDetail;
    private String address;
    private int price;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
