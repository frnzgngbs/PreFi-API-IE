package com.Order.Service;

import com.Order.Entity.Costumer;
import com.Order.Repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostumerService {
    private CostumerRepository costumerRepository;

    @Autowired
    public CostumerService(CostumerRepository customerRepository) {
        this.costumerRepository = customerRepository;
    }

    public Costumer createCostumer(Costumer customer) {
        return costumerRepository.save(customer);
    }


    public List<Costumer> queryAll() {
        return costumerRepository.findAll();
    }

    public Costumer editCostumer(Costumer updatedCustomer) {
        Costumer existingCustomer = costumerRepository.findById(updatedCustomer.getCostumerId()).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setCostumerName(updatedCustomer.getCostumerName());
            existingCustomer.setAddress(updatedCustomer.getAddress());
            existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
            return costumerRepository.save(existingCustomer);
        }
        return null; // or throw an exception if needed
    }

    public Costumer deleteCostumer(Long costumerId) {
        Optional<Costumer> deletedCostumer = costumerRepository.findById(costumerId);
        if(deletedCostumer.isPresent()) {
            costumerRepository.deleteById(costumerId);
        }
        return deletedCostumer.get();
    }
}

