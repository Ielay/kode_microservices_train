package com.kode.cardholder.service;

import com.kode.cardholder.domain.Card;
import com.kode.cardholder.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public List<Card> findAllByAccountId(Long accountId) {
        return cardRepository.findAllByAccountId(accountId);
    }
}
