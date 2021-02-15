package com.nyamita.paymentgateway.transaction.service;

import com.nyamita.paymentgateway.account.Account;
import com.nyamita.paymentgateway.transaction.Transaction;
import com.nyamita.paymentgateway.transaction.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
public class TransactionServiceImpl implements TransactionService {

    private  final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction register(Transaction transaction){
        log.info("Register an account :{}"+transaction);
        return transactionRepository.save(transaction);
    }


    public Optional<Transaction> findByAccountNumber(String accountNumber) {
        return transactionRepository.findByAccountNumber(accountNumber);
    }

    public List<Transaction> findAllTransaction() {

        log.debug("Getting all transaction {}:");

        return transactionRepository.findAll();
    }
}
