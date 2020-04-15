package com.ecommercepractice.authentication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class AuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}
	@Bean
	public CommandLineRunner test1(){
		return (args) -> {
			String ram = UUID.randomUUID().toString();
			System.out.println(String.format("Length %s char -> %s", ram.length(),ram));

			ram = UUID.randomUUID().toString();
			System.out.println(String.format("Length %s char -> %s", ram.length(),ram));

			ram = UUID.randomUUID().toString();
			System.out.println(String.format("Length %s char -> %s", ram.length(),ram));

			ram = UUID.randomUUID().toString();
			System.out.println(String.format("Length %s char -> %s", ram.length(),ram));

			ram = UUID.randomUUID().toString();
			System.out.println(String.format("Length %s char -> %s", ram.length(),ram));

			ram = UUID.randomUUID().toString();
			System.out.println(String.format("Length %s char -> %s", ram.length(),ram));

		};
	}

}
