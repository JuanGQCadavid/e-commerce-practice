package com.fakeservers.cardFake;

import com.fakeservers.cardFake.models.Card;
import com.fakeservers.cardFake.repository.CardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CardFakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardFakeApplication.class, args);
	}

	@Bean
	public CommandLineRunner createCards(CardRepository cardRepository){
		return (args) -> {
			cardRepository.save(new Card(1,
					"4716-5582-6332-7797",
					"772",
					"10/20",
					"DICKINSON",
					"REBECCA",
					1000000.0));

			cardRepository.save(new Card(2,
					"4532-8569-2193-4836",
					"382",
					"12/21",
					"NASH",
					"MOLLY ",
					1000000.0));

			cardRepository.save(new Card(3,
					"4485-0474-5122-0369",
					"992",
					"03/21",
					"CAREY",
					"THOMAS",
					1000000.0));
		};
	}
}
