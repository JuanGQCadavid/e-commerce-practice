package com.ecommercepractice.paymentservice.repository;

import com.ecommercepractice.paymentservice.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}
