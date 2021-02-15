package com.nyamita.paymentgateway.transaction.repository;

import com.nyamita.paymentgateway.account.Account;
import com.nyamita.paymentgateway.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findByAccountNumber(String accountNumber);
}
