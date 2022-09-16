package com.cust.transaction.services;

import com.cust.transaction.dto.RewardsDto;

import java.util.List;

public interface CustSvc {

    List<RewardsDto> getMonthlyRewards();
}
