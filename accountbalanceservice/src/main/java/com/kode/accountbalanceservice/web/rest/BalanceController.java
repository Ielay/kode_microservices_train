package com.kode.accountbalanceservice.web.rest;

import com.kode.accountbalanceservice.domain.Balance;
import com.kode.accountbalanceservice.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/accounts")
public class BalanceController {

    @Autowired
    private BalanceService balanceService;

    @GetMapping("/{accountId}/balance")
    public ResponseEntity<Balance> find(@PathVariable Long accountId) {
        Balance balance = balanceService.findByAccountId(accountId);

        if (balance == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(balance);
        }
    }
}
