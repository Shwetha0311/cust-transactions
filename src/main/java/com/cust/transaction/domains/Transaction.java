package com.cust.transaction.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TRANSACTION")
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "cust_id", nullable = false)
    private Customer customer;

    @Column(name = "TRANSACTION")
    private double transaction;

    @Column(name = "TRAN_DATE")
    private LocalDate transactionDate;

}
