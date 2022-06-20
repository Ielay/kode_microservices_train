package com.kode.accountbalanceservice.repository;

import com.kode.accountbalanceservice.domain.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {

    Balance findByAccountId(Long accountId);
}
