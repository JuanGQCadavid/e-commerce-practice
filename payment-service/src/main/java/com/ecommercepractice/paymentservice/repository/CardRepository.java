package com.ecommercepractice.paymentservice.repository;

import com.ecommercepractice.paymentservice.models.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Integer> {
}
