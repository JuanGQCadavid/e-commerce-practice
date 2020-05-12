package com.ecommercepractice.orderservice.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * This model is use to the client's request responses.
 * This defines the fields of the response.
 */
@Data
public class OrderDTO {
    private Integer orderId;

    private Integer userId;

    private List<OrderProductList> products;

    private LocalDate date;

    private String amount;

    private String paymentBill;

    public OrderDTO(Orders orders, List<OrderProductList> products){
        this.orderId = orders.getOrderId();
        this.userId = orders.getUserId();
        this.date = orders.getDate();
        this.amount = orders.getAmount();
        this.paymentBill = orders.getPaymentBill();
        this.products = products;
    }
}
