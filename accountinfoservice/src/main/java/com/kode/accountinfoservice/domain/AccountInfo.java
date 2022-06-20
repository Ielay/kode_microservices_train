package com.kode.accountinfoservice.domain;

import com.kode.accountinfoservice.dto.AccountBalanceDTO;
import com.kode.accountinfoservice.dto.CardDTO;

import java.util.List;

public class AccountInfo {

    private Long accountId;

    private AccountBalanceDTO balance;

    private List<CardDTO> cards;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public AccountBalanceDTO getBalance() {
        return balance;
    }

    public void setBalance(AccountBalanceDTO balance) {
        this.balance = balance;
    }

    public List<CardDTO> getCards() {
        return cards;
    }

    public void setCards(List<CardDTO> cards) {
        this.cards = cards;
    }
}
