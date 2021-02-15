package com.nyamita.paymentgateway.payment.api.model.service;

import com.nyamita.paymentgateway.account.Account;
import com.nyamita.paymentgateway.account.repository.AccountRepository;
import com.nyamita.paymentgateway.account.service.AccountService;
import com.nyamita.paymentgateway.payment.api.model.Payment;
import com.nyamita.paymentgateway.payment.api.model.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
public class PaymentServiceImpl implements PaymentService {


  private final PaymentRepository paymentRepository;


  public PaymentServiceImpl(PaymentRepository paymentRepository){
    this.paymentRepository= paymentRepository;
  }

  @Override
  public Payment register(Payment payment) {

    log.info("Register a payment :{}"+payment);
    return paymentRepository.save(payment);
  }

    @Override
    public Optional<Payment> findByPaymentId(String paymentId) {
        return paymentRepository.findByPaymentId(paymentId);
    }

    @Override
    public List<Payment> findAllPayment() {

        log.debug("Getting all payments {}:");
        return paymentRepository.findAll();

}

  @Override
  public Payment update(Payment payment) {

    log.info("Updating an account with Id:{}" + payment);
    Payment pay = checkPaymentAvailability(payment.getId());
    return paymentRepository.save(pay);

  }

  @Override
  public void delete(Long Id) {
    log.info("Deleting a payment with Id:{}" + Id);
    Payment pay = checkPaymentAvailability(Id);
    pay.setDeleted(true);
    paymentRepository.save(pay);
  }

  public Payment checkPaymentAvailability(Long Id){

    Optional<Payment> payment = paymentRepository.findById(Id);
    if (payment.isPresent()) {
      return payment.get();
    } else {
      throw new IllegalArgumentException("The give ID is not found in the database ");
    }
}
}
