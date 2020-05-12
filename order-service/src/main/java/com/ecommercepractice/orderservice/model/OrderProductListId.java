package com.ecommercepractice.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OrderProductListId implements Serializable {
    @NotNull
    private Integer orderProductListUniqueId;

    @NotNull
    private Integer productId;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + orderProductListUniqueId.hashCode();
        hash = 59 * hash + productId.hashCode();

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
        if (!orderProductListId.getProductId().equals(this.productId)){
            return false;
        }
        return true;
    }
}

