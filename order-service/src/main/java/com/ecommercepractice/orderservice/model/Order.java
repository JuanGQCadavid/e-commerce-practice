package com.ecommercepractice.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {
    @Id
    private Integer orderId;

    private Integer userId;

    private Integer orderProductListId;

    private LocalDate date;

    private String paymentBill;
}
