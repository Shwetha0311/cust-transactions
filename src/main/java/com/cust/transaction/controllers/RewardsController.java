package com.cust.transaction.controllers;

import com.cust.transaction.dto.RewardsDto;
import com.cust.transaction.services.CustSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class RewardsController {

    @Autowired
    private CustSvc custSvc;

    @RequestMapping("/cust_rewards")
    public ResponseEntity<List<RewardsDto>> getRewards() {
        return ResponseEntity.ok(custSvc.getMonthlyRewards());
    }
}
