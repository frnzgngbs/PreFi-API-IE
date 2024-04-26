package com.Order.Controller;

import com.Order.Entity.Costumer;
import com.Order.Entity.Order;
import com.Order.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {

    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/get-orders")
    public ResponseEntity<?> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }


    @DeleteMapping("/delete-order/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        Order deletedOrder = orderService.deleteOrder(id);
        if(deletedOrder != null) {
            return ResponseEntity.ok(deletedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
