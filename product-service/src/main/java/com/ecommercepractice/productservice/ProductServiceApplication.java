package com.ecommercepractice.productservice;

import com.ecommercepractice.productservice.model.Product;
import com.ecommercepractice.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductServiceApplication {
	@Autowired
	ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner createInitialProducts(){
		return args -> {
			productService.createProduct(new Product("Tapabocas Delux","Tapabocas",56.7,null));
			productService.createProduct(new Product("Higienico Delux","Higienico",57.7,null));
			productService.createProduct(new Product("Desodorante Rexona","Higienico",58.7,null));
			productService.createProduct(new Product("Talco Rexona Delux","Talco",60.7,null));
			productService.createProduct(new Product("toballasDelux Ultra","Talco",57.7,null));
		};
	}
}
