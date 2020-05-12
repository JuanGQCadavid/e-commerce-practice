package com.ecommercepractice.orderservice.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDTO {
    private Integer orderId;

    private Integer userId;

    private List<OrderProductList> products;

    private LocalDate date;

    private String amount;

    private String paymentBill;

    public OrderDTO(Order order, List<OrderProductList> products){
        this.orderId = order.getOrderId();
        this.userId = order.getUserId();
        this.date = order.getDate();
        this.amount = order.getAmount();
        this.paymentBill = order.getPaymentBill();
        this.products = products;
    }
}
