package com.cust.transaction.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RewardsDto {

    private long id;
    private String name;
    private String month;
    private long rewards;
}
