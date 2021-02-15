package com.nyamita.paymentgateway.payment.api.model.repository;

import com.nyamita.paymentgateway.account.Account;
import com.nyamita.paymentgateway.payment.api.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    Optional<Payment> findByPaymentId(String paymentId);
}
