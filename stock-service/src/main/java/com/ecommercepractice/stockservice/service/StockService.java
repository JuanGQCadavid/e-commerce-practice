package com.ecommercepractice.stockservice.service;

import com.ecommercepractice.stockservice.exception.InsufficientStockException;
import com.ecommercepractice.stockservice.exception.StockFreezeInsufficientException;
import com.ecommercepractice.stockservice.exception.StockNotFoundedException;
import com.ecommercepractice.stockservice.exception.StockProductAlreadyOnInventoryException;
import com.ecommercepractice.stockservice.model.Stock;
import com.ecommercepractice.stockservice.reporitory.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockService {
    @Autowired
    StockRepository stockRepository;

    /**
     * Check if the product is inside the register, if not raise StockProductAlreadyOnInventoryException
     * @param productId
     */
    public void validProductIdOnStock(Long productId){
        Optional.ofNullable(stockRepository.findActiveProductById(productId))
                .ifPresent(inventory -> {throw new StockProductAlreadyOnInventoryException(productId);});
    }

    /**
     * Save a Stock product inside the register.
     * @param productStock
     * @return
     */
    public Stock appendToInventory(Stock productStock){
        validProductIdOnStock(productStock.getIdProduct());

        productStock.setSoldQuantity(productStock.getSoldQuantity() != null ? productStock.getSoldQuantity() : 0);
        productStock.setFreezeQuantity(productStock.getFreezeQuantity() != null ? productStock.getFreezeQuantity() : 0);
        productStock.setActive(true);

        return stockRepository.save(productStock);
    }

    /**
     * Checks if the operation of adding freeze quantity to the
     * total would lead to leak of stock.
     *
     * Also, it's used to check when a sold operation is being doing
     * the result of tha operation ends without a leak on the stock.
     * @param stock
     * @param minusStock
     * @return
     */
    public Long calculateRemainingStock(Stock stock, Long minusStock){
        Long remaining = stock.getStockQuantity() - (stock.getFreezeQuantity() + stock.getSoldQuantity());
        remaining -= minusStock;
        return remaining < 0 ? null : remaining;
    }

    /**
     * Freeze the stock adding freeze Quantities to the freeze counter.
     * @param stockId
     * @param freezeQuantities
     */
    public void freezeStockItem(Long stockId,Long freezeQuantities){
        Stock stockToFreeze = stockRepository.findById(stockId)
                .orElseThrow(() -> new StockNotFoundedException(stockId));

        Optional.ofNullable(calculateRemainingStock(stockToFreeze, freezeQuantities))
                .orElseThrow(() -> new InsufficientStockException(stockToFreeze));

        stockToFreeze.setFreezeQuantity(stockToFreeze.getFreezeQuantity() + freezeQuantities);
        stockRepository.save(stockToFreeze);
    }

    /**
     * fetch a Stock product with its id.
     * if the product is no inside the register then a
     * StockNotFoundedException would arise.
     * @param stockId
     * @return
     */
    public Stock fetchByStockId(Long stockId){
        return stockRepository.findById(stockId)
                .orElseThrow(() -> new StockNotFoundedException(stockId));
    }

    /**
     *
     * Updates from a certain Stock product identified by stockId their
     * stockQuantity and/or their salePrice
     * @param stockId
     * @param stockQuantity Optional, if no present the previous value remains.
     * @param salePrice Optional, if no present the previous value remains.
     * @return
     */
    public Stock updateByStockId(Long stockId, Long stockQuantity, Float salePrice){
        Stock internalStock = fetchByStockId(stockId); // Let's check that the product id exist.

        stockQuantity = stockQuantity == null ? internalStock.getStockQuantity() : stockQuantity;
        salePrice = salePrice == null ? internalStock.getSalePrice() : salePrice;

        internalStock.setStockQuantity(stockQuantity);
        internalStock.setSalePrice(salePrice);

        Optional.ofNullable(calculateRemainingStock(internalStock, 0l))
                .orElseThrow(() -> new InsufficientStockException(internalStock));

        return stockRepository.save(internalStock);
    }

    /**
     * Toggle activateState to false, indicating stock's product
     * is no longer available for users but for logging propose.
     * @param stockId
     */
    public void deleteByStockId(Long stockId){
        Stock internalStock = fetchByStockId(stockId);
        internalStock.setActive(false);
        stockRepository.save(internalStock);
    }

    /**
     * Check if there is such amount on freeze quantity
     * if so then perform the repository update and return it.
     * @param stockId
     * @param boughtQuantity
     * @return
     */
    public Stock boughtStockItem(Long stockId, Long boughtQuantity){
        Stock stockToBought = stockRepository.findById(stockId)
                .orElseThrow(() -> new StockNotFoundedException(stockId));

        stockToBought = transferFreezeToBought(stockToBought,boughtQuantity);

        return stockRepository.save(stockToBought);
    }

    /**
     * Validate if there is enough freeze elements in order to
     * proceed with the purchased, in case there is more sold
     * elements than freeze one then a StockFreezeInsufficientException should
     * arise.
     * @param stockToBought
     * @param boughtQuantity
     * @return
     */

    public Stock transferFreezeToBought(Stock stockToBought, Long boughtQuantity){
        // Bought Quantity must be less or equals to freeze Quantity
        if (stockToBought.getFreezeQuantity() < boughtQuantity){
            throw new StockFreezeInsufficientException(stockToBought, boughtQuantity);
        }
        stockToBought.setSoldQuantity(stockToBought.getSoldQuantity() + boughtQuantity);
        stockToBought.setFreezeQuantity(stockToBought.getFreezeQuantity() - boughtQuantity);
        return  stockToBought;
    }

    /**
     * Filter products by their corresponding flags.
     * it start fetching by only active if the flag is true, all if not,
     * them the products fetched goes throwout a process of filtering
     * by the others flags.
     *
     * @param price Optional, if no present the flow keeps normal
     * @param stockQuantity Optional, if no present the flow keeps normal
     * @param soldQuantity Optional, if no present the flow keeps normal
     * @param onlyActive Indicates if the process should start with only Active or not.
     * @return
     */
    public List<Stock> fetchByFiltering(Float price, Long stockQuantity, Long soldQuantity, Boolean onlyActive){
        onlyActive = Optional.ofNullable(onlyActive).orElseGet(() -> true);
        List<Stock> filterList = onlyActive  ? stockRepository.fetchAllActiveStockProducts() :
                stockRepository.fetchAllStockProducts();

        return filterList
                .stream()
                .filter(stock -> price == null || stock.getSalePrice() <= price)
                .filter(stock -> stockQuantity == null || stock.getStockQuantity() <= stockQuantity)
                .filter(stock -> soldQuantity == null || stock.getSoldQuantity() <= soldQuantity)
                .collect(Collectors.toList());
        }
}