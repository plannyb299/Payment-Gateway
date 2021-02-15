package com.nyamita.paymentgateway.account.api;

import com.nyamita.paymentgateway.account.Account;
import com.nyamita.paymentgateway.account.service.AccountService;
import com.nyamita.paymentgateway.common.exceptions.RecordNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {

  private final AccountService accountService;

  private AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @PostMapping(value = "/create")
  public ResponseEntity<Account> register(@Valid @RequestBody Account account) {

    log.info("Account is{}: " + account);
    Account acc = accountService.register(account);
    return new ResponseEntity<>(acc, HttpStatus.CREATED);
  }

  @GetMapping("/search/{accountnumber}")
  public ResponseEntity<Optional<Account>> getByAccountNumber(@PathVariable(name = "accountnumber") String accountNumber) {

    log.info("Account is{}: " + accountNumber);
    Optional<Account> account = accountService.findByAccountNumber(accountNumber);
    return new ResponseEntity<>(account, HttpStatus.OK);

  }

  //Implement Delete and Update Rest API
  @PutMapping("/update/{id}")
  public ResponseEntity<Account> update(@RequestBody Account account, @PathVariable Long id) throws RecordNotFoundException {

    log.info("Updating an account with Id:{}" + account);
    accountService.update(account);
    return new ResponseEntity<>(account, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public void delete(@PathVariable Long id) throws RecordNotFoundException {

    log.info("Deleting a payment with Id:{}" + id);
    accountService.delete(id);
  }


}
