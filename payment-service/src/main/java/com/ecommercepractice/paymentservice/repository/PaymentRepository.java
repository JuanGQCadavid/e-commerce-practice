package com.ecommercepractice.paymentservice.repository;

import com.ecommercepractice.paymentservice.models.Payment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

    List<Payment> findAll();
}
