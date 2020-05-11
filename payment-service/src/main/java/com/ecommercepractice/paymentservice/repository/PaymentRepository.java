package com.ecommercepractice.paymentservice.repository;

import com.ecommercepractice.paymentservice.models.Payment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
    /**
     * Fetch all payments.
     * @return
     */
    List<Payment> findAll();

    /**
     * Fetch a payment by its bill number.
     * @param billNumber
     * @return
     */
    Optional<Payment> findByBillNumber(String billNumber);
}
