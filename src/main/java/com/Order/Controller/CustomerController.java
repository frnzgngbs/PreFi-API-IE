package com.Order.Controller;

import com.Order.Entity.Costumer;
import com.Order.Service.CostumerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private final CostumerService costumerService;

    public CustomerController(CostumerService costumerService) {
        this.costumerService = costumerService;
    }

    @GetMapping("/get-costumers")
    private ResponseEntity<?> getAllCostumer() {
        return ResponseEntity.ok(costumerService.queryAll());
    }

    @PostMapping("/add-costumer")
    private ResponseEntity<?> addCustomer(@RequestBody Costumer customer) {
        Costumer costumer = costumerService.createCostumer(customer);
        return ResponseEntity.ok(costumer);
    }

    @PutMapping("/edit-costumer")
    private ResponseEntity<?> editCustomer(@RequestBody Costumer updatedCustomer) {
        Costumer editedCustomer = costumerService.editCostumer(updatedCustomer);
        if (editedCustomer != null) {
            return ResponseEntity.ok(editedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-costumer/{id}")
    private ResponseEntity<?> deleteCostumer(@PathVariable Long id) {
        Costumer editedCustomer = costumerService.deleteCostumer(id);
        if (editedCustomer != null) {
            return ResponseEntity.ok(editedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
