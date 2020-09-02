package com.vika.learn.repository.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vika.learn.model.transaction.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
