package com.Order.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long costumerId;

    private String costumerName;
    private String address;
    private Long phoneNumber;

    public Costumer(String costumerName, String address, Long phoneNumber) {
        this.costumerName = costumerName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


    public Costumer() {

    }

    @Override
    public String toString() {
        return costumerName;
    }
}
