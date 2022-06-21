package com.kode.accountbalanceservice.service;

import com.kode.accountbalanceservice.domain.Balance;
import com.kode.accountbalanceservice.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BalanceService {

    @Autowired
    private BalanceRepository balanceRepository;

    @Transactional(readOnly = true)
    public Balance findByAccountId(Long accountId) {
        return balanceRepository.findByAccountId(accountId);
    }
}
