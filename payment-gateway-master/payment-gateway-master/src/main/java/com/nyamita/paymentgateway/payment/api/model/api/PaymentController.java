package com.nyamita.paymentgateway.payment.api.model.api;

import com.nyamita.paymentgateway.account.Account;
import com.nyamita.paymentgateway.account.service.AccountService;
import com.nyamita.paymentgateway.payment.api.model.Payment;
import com.nyamita.paymentgateway.payment.api.model.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.NoSuchElementException;
import java.util.Optional;


@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

  private final PaymentService paymentService;

  private PaymentController(PaymentService paymentService){
    this.paymentService = paymentService;
  }

  @PostMapping(value="/create")

  public ResponseEntity<Payment> register(@Valid @RequestBody Payment payment ){

    log.info("Payment is{}: " +payment);
    Payment py = paymentService.register(payment);
    return new ResponseEntity<>(py,HttpStatus.CREATED);
  }

  @GetMapping("/search/{paymentid}")
  public ResponseEntity<Optional<Payment>> getByPaymentId(@PathVariable(name="paymentid")  String paymentId) {

    log.info("Payment is{}: " + paymentId);
    Optional<Payment> payment  = paymentService.findByPaymentId(paymentId);
    return new ResponseEntity<>(payment,HttpStatus.OK);

  }

  @PutMapping("/update/{id}")
  public ResponseEntity<Payment> update(@RequestBody Payment payment, @PathVariable Long id) {

      log.info("Updating an account with Id:{}" + payment);
      paymentService.update(payment);
     return new ResponseEntity<>(payment, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public void delete(@PathVariable Long id) {

    log.info("Deleting a payment with Id:{}" + id);
    paymentService.delete(id);
  }


}
