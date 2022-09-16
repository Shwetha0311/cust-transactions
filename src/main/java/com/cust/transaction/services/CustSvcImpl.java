package com.cust.transaction.services;

import com.cust.transaction.domains.Customer;
import com.cust.transaction.domains.Transaction;
import com.cust.transaction.dto.RewardsDto;
import com.cust.transaction.repos.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CustSvcImpl implements CustSvc {

    @Autowired
    private TransactionRepository customerRepository;

    @Override
    public List<RewardsDto> getMonthlyRewards() {
        List<Transaction> customers = customerRepository.getAllTransactions();
        Map<Long, List<Transaction>> collect = customers.stream().collect(Collectors.groupingBy((tr) -> tr.getCustomer().getId()));
        final List<RewardsDto> rewardsDtos = new ArrayList<>();

        collect.entrySet().forEach(entry -> {
            Customer customer = entry.getValue().get(0).getCustomer();
            Map<String, List<Transaction>> monthWise = entry.getValue().stream().collect(Collectors.groupingBy((tr) -> tr.getTransactionDate().getMonth().name()));
            monthWise.entrySet().forEach(entryIn -> {
                long rewards = 0;
                for (Transaction tr : entryIn.getValue()) {
                    rewards += calculateRewards(tr.getTransaction());
                }
                rewardsDtos.add(RewardsDto.builder().id(customer.getId()).name(customer.getName()).month(entryIn.getKey()).rewards(rewards).build());
            });
        });
        return rewardsDtos;
    }

    private long calculateRewards(double transaction) {
        long rewards = 0;
        if (transaction > 100)
            rewards += ((transaction - 100) * 2) + (50);
        else if (transaction < 100 && transaction > 50)
            rewards += (transaction - 50);
        return rewards;
    }
}
