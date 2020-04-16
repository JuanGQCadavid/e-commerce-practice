package com.ecommercepractice.productservice.model;

import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.Entity;
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
    private int idProduct;

    @NotEmpty
    @Size(min = 0, max= 45)
    private String name;

    @NotEmpty
    @Size(min = 0, max = 45)
    private String description;

    private String photoUrl;

    public Product(String name, String description, String photoUrl){
        this.name = name;
        this.description = description;
        this.photoUrl = photoUrl;
    }

    public Product(String name, String description){
        this.name = name;
        this.description = description;
        this.photoUrl = "http://imgs.com/default.png";
    }
}
