package com.cust.transaction.repos;

import com.cust.transaction.domains.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    @Query("from Transaction t")
    List<Transaction> getAllTransactions();
}
