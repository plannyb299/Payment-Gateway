package com.nyamita.paymentgateway.account.service;

import com.nyamita.paymentgateway.account.Account;
import com.nyamita.paymentgateway.common.exceptions.RecordNotFoundException;

import java.util.List;
import java.util.Optional;

public interface AccountService  {

  Account register(Account account);
  Optional<Account> findByAccountNumber(String accountNumber);
  List<Account> findAllAccount();
  Account update ( Account account) throws RecordNotFoundException;
  void delete(Long Id) throws RecordNotFoundException;

}
