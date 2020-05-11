package com.ecommercepractice.paymentservice.repository;

import com.ecommercepractice.paymentservice.models.Bill;
import com.ecommercepractice.paymentservice.models.Payment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

    List<Payment> findAll();
    Optional<Payment> findByBillNumber(String billNumber);
}
