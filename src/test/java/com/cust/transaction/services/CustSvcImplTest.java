package com.cust.transaction.services;

import com.cust.transaction.domains.Customer;
import com.cust.transaction.domains.Transaction;
import com.cust.transaction.dto.RewardsDto;
import com.cust.transaction.repos.TransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class CustSvcImplTest {

    @InjectMocks
    private CustSvcImpl custSvc;

    @Mock
    private TransactionRepository customerRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testMonthlyRewards() {
        List<Transaction> transactions = getTransactions();
        Mockito.when(customerRepository.getAllTransactions()).thenReturn(transactions);
        List<RewardsDto> rewardsDtos = custSvc.getMonthlyRewards();
        Assertions.assertNotNull(rewardsDtos);
        Assertions.assertFalse(rewardsDtos.isEmpty());
        Assertions.assertTrue(rewardsDtos.size() == 2);
        Assertions.assertEquals(Month.APRIL.name(), rewardsDtos.get(0).getMonth());
        Assertions.assertEquals(Month.SEPTEMBER.name(), rewardsDtos.get(1).getMonth());
        Assertions.assertEquals(1l, rewardsDtos.get(1).getRewards());
        Assertions.assertEquals(180l, rewardsDtos.get(0).getRewards());
    }

    private List<Transaction> getTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(createTransaction(1, LocalDate.of(2022, Month.APRIL, 26),
                60, 1, "John"));
        transactions.add(createTransaction(2, LocalDate.of(2022, Month.APRIL, 22),
                160, 1, "John"));
        transactions.add(createTransaction(3, LocalDate.of(2022, Month.SEPTEMBER, 26),
                51, 3, "Tom"));
        return transactions;
    }

    public Transaction createTransaction(long transactionId, LocalDate localDate, double transaction,
                                         long custId, String custName) {
        Transaction transaction1 = new Transaction();
        transaction1.setId(transactionId);
        transaction1.setTransaction(transaction);
        transaction1.setTransactionDate(localDate);
        Customer customer = new Customer();
        customer.setId(custId);
        customer.setName(custName);
        transaction1.setCustomer(customer);
        return transaction1;
    }

}
