package com.ecommercepractice.orderservice.model.confirm;

import lombok.Data;

import java.util.List;

@Data
public class ConfirmationModel {
    private List<Product> productList;
    private String amount;
    private String paymentBill;
}
