package com.nyamita.paymentgateway.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nyamita.paymentgateway.common.BaseEntity;
import com.nyamita.paymentgateway.payment.api.model.Payment;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "accounts", indexes = {@Index(name = "indx_account", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Account extends BaseEntity {

  @Column(name = "accountnumber", nullable = false, length = 45)
  private String accountNumber;
  @Column(name = "accountdescription", nullable = false)
  private String accountDescription;
  @Column(name = "accountholder", nullable = false)
  private  String accountHolder;
  @Column(name = "accountissuerbank", nullable = false, length = 45)
  private String accountIssuerBank;

  //create

}
