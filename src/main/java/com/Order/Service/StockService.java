package com.Order.Service;

import com.Order.Entity.Stock;
import com.Order.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public List<Stock> getStocks() {
        return stockRepository.findAll();
    }


//    public Stock modifyStock(Stock stock) throws Exception {
//        Optional<Stock> queryStock = stockRepository.findById(stock.getProduct());
//        if(queryStock.isEmpty()) {
//            throw new Exception("Cannot find stock");
//        }
//        Stock modifiedStock = new Stock(queryStock.get().getProduct(), stock.getQuantity(), stock.getQuantity());
//        return stockRepository.save(modifiedStock);
//    }
}
