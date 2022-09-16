package com.cust.transaction.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany(mappedBy = "customer")
    private List<Transaction> transactions;


}
