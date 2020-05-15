package com.ecommercepractice.orderservice.model.confirm;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.List;

/**
 * Model maps require information to create order.
 * it is use at the controller as the expected clients request body.
 * This is the client contract.
 */
@Data
public class ConfirmationModel {
    @NotNull
    @Valid
    private List<Product> productList;

    @NotEmpty
    private String amount;

    @NotEmpty
    private String paymentBill;
}
