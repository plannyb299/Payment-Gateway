package com.nyamita.paymentgateway.transaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nyamita.paymentgateway.common.BaseEntity;
import com.nyamita.paymentgateway.payment.api.model.Payment;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transactions", indexes = {@Index(name = "indx_transaction", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Transaction extends BaseEntity {


    @Column(name = "amount", nullable = false)
    private Double amount;

     @ManyToOne(cascade = CascadeType.ALL, targetEntity = Payment.class)
    @JoinColumn(name="payment_id")
    private Payment paymentId;

    @Column(name = "charges", nullable = false)
    private Double charges;
    @Column(name = "description", nullable = false, length = 70)
    private String description;
    @Column(name = "accountnumber", nullable = false, length = 12)
    private String accountNumber;
    @Column(name = "deposit", nullable = false)
    private Double deposit;
    @Column(name = "withdrawal")
    private Double withdrawal;
    @Column(name = "depositdate", nullable = false)
    private LocalDate depositDate;
    @Column(name = "withdrawaldate", nullable = false)
    private LocalDate withdrawalDate;
}
