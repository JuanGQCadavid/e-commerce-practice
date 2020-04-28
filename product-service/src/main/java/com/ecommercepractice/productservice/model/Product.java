package com.ecommercepractice.productservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long idProduct;

    @NotEmpty
    @Size(min = 0, max= 45)
    @ApiModelProperty(value = "Product's name")
    private String name;

    @NotEmpty
    @Size(min = 0, max = 45)
    @ApiModelProperty(value = "Product's description")
    private String description;

    @NotNull
    @ApiModelProperty(value = "Product's price")
    private Double price;

    @ApiModelProperty(value = "Product's photo, if there is missing a default photo" +
            " is going to be used instead")
    private String photoUrl;

    public Product(String name, String description, Double price, String photoUrl){
        this.name = name;
        this.description = description;
        this.photoUrl = photoUrl;
        this.price = price;

    }
}
