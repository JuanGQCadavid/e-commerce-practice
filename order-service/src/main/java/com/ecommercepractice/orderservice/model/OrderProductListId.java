package com.ecommercepractice.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@AllArgsConstructor
@Embeddable
public class OrderProductListId {

    private Integer orderProductListUniqueId;
    private Integer productStockId;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + orderProductListUniqueId.hashCode();
        hash = 59 * hash + productStockId.hashCode();

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(obj == null){
            return false;
        }
        final OrderProductListId orderProductListId = (OrderProductListId) obj;
        if(!orderProductListId.getOrderProductListUniqueId().equals(this.orderProductListUniqueId)){
            return false;
        }
        if (!orderProductListId.getProductStockId().equals(this.productStockId)){
            return false;
        }
        return true;
    }
}

