package com.ecommercepractice.userservice;

import com.ecommercepractice.userservice.repository.UserRepository;
import com.ecommercepractice.userservice.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Slf4j
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new User("asd123","Jack", "Bauer",true, "Jack.Bauer"));
			repository.save(new User("qwe123","Chloe", "O'Brian",true,"Chloe.O'Brian"));
			repository.save(new User("zxc123","Kim", "Bauer",true,"Kim.Bauer"));
			repository.save(new User("zse123","David", "Palmer",false,"David.Palmer"));
			repository.save(new User("qsc123","Michelle", "Dessler",false,"Michelle.Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (User user : repository.findAll()) {
				log.info(user.toString());
			}
			log.info("");

			/*
			// fetch an individual customer by ID
			User user = repository
					.findById("")
					.get();
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			log.info("");
			*/
		};
	}

	/*
	@Bean
	public CommandLineRunner demo(UserRepositoryTest repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customers("Jack", "Bauer"));
			repository.save(new Customers("Chloe", "O'Brian"));
			repository.save(new Customers("Kim", "Bauer"));
			repository.save(new Customers("David", "Palmer"));
			repository.save(new Customers("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customers customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customers customer = repository
					.findById(1L)
					.get();
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			log.info("");
		};
	}
	*/


}
