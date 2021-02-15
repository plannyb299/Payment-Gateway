package com.nyamita.paymentgateway.account.repository;

import com.nyamita.paymentgateway.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {

  Optional<Account> findByAccountNumber(String accountNumber);


}
