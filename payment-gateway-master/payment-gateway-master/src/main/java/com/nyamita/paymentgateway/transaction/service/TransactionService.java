package com.nyamita.paymentgateway.transaction.service;

import com.nyamita.paymentgateway.transaction.Transaction;

public interface TransactionService {

    Transaction register(Transaction transaction);
}
