package com.nyamita.paymentgateway.transaction.api;

import com.nyamita.paymentgateway.account.Account;
import com.nyamita.paymentgateway.transaction.Transaction;
import com.nyamita.paymentgateway.transaction.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@Slf4j
@RestController
@RequestMapping("/transaction")

public class TransactionController {

    private final TransactionService transactionService;

    private  TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }
    @PostMapping(value="/create")

    public ResponseEntity<Transaction> register(@Valid @RequestBody Transaction transaction){

        log.info("Transaction is{}: " +transaction);
        Transaction tran = transactionService.register(transaction);
        return new ResponseEntity<>(tran,HttpStatus.CREATED);
    }
}
