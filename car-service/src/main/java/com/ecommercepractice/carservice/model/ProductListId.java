package com.ecommercepractice.carservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 * Embeddable Product list Id, It's used as the primary key od Product List.
 * Actually, it is a combination ( A composed primary key ) bwt idProductList and
 * idProductStock.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ProductListId implements Serializable {

    @ApiModelProperty(notes = "Holds the indicator of products associate to a cart", value = "Product List id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer idProductList;

    @ApiModelProperty(value ="Product Stock id", notes = "Product's stock id.")
    private Integer idProductStock;

    @Override
    public int hashCode() {
        int hash = 7;

        hash = 59 * hash +idProductList.hashCode();
        hash = 59 * hash +idProductStock.hashCode();

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
        final ProductListId productListId = (ProductListId) obj;
        if(!productListId.getIdProductList().equals(this.idProductList)){
            return false;
        }
        if (!productListId .getIdProductStock().equals(this.idProductStock)){
            return false;
        }
        return true;
    }
}
