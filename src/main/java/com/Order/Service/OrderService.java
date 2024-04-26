package com.Order.Service;

import com.Order.Entity.Costumer;
import com.Order.Entity.Order;
import com.Order.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order deleteOrder(Long id) {
        Optional<Order> deletedOrder = orderRepository.findById(id);
        if(deletedOrder.isPresent()) {
            orderRepository.deleteById(id);
        }
        return deletedOrder.get();
    }

}
