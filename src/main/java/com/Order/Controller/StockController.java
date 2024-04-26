package com.Order.Controller;

import com.Order.Entity.Costumer;
import com.Order.Entity.Stock;
import com.Order.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/add-stock")
    public ResponseEntity<?> addStock(@RequestBody Stock stock) {
        Stock added_stock = stockService.addStock(stock);
        return ResponseEntity.ok(added_stock);
    }


    @GetMapping("/get-stocks")
    public ResponseEntity<?> getStocks() {
        return ResponseEntity.ok(stockService.getStocks());
    }


    @PutMapping("/modify-stock")
    public ResponseEntity<?> modifyStock(@RequestBody Stock stock) throws Exception {

        return null;
    }

}
