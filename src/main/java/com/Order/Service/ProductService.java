package com.Order.Service;

import com.Order.Entity.Product;
import com.Order.Repository.ProductRepository;
import com.Order.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
