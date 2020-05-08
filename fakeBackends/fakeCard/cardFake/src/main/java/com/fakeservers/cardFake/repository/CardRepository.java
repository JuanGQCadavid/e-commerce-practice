package com.fakeservers.cardFake.repository;

import com.fakeservers.cardFake.models.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardRepository extends CrudRepository<Card, Integer> {

    Card findByTccNumber(String tccNumber);

    List<Card> findAll();
}
