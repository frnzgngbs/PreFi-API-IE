package com.Order.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "costumer_id")
    private Costumer costumer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Date orderDate;

    public Order(Costumer costumer, Product product, Date orderDate) {
        this.costumer = costumer;
        this.product = product;
        this.orderDate = orderDate;
    }

    public Order() {

    }
}
