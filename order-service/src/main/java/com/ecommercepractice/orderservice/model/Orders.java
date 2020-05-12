package com.ecommercepractice.orderservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel(value = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @ApiModelProperty(value = "Order's identifier.")
    private Integer orderId;

    @ApiModelProperty(value = "UserId of User owner of the order.")
    @NotEmpty
    private Integer userId;

    @ApiModelProperty(value = "UniqueId that maps the products list.")
    @NotNull
    private Integer orderProductListUniqueId;

    @ApiModelProperty(value = "Order's date of creation")
    @NotEmpty
    private LocalDate date;

    @ApiModelProperty(value = "Order's total amount")
    @NotEmpty
    private String amount;

    @ApiModelProperty(value = "Payment bill id.")
    @NotEmpty
    private String paymentBill;
}
