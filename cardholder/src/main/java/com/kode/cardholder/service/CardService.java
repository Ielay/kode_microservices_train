package com.kode.cardholder.service;

import com.kode.cardholder.domain.Card;
import com.kode.cardholder.dto.NewCardInfoDTO;
import com.kode.cardholder.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Transactional
    public Long createNewCard(Long accountId, NewCardInfoDTO newCardInfo) {
        Card savedCard = cardRepository.save(mapFromDTO(accountId, newCardInfo));

        return savedCard.getId();
    }

    private Card mapFromDTO(Long accountId, NewCardInfoDTO dto) {
        Card entity = new Card();
        entity.setAccountId(accountId);
        entity.setCardNumber(dto.getCardNumber());
        entity.setCcv(dto.getCcv());
        entity.setValidThrough(dto.getValidThrough());

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Card> findAllByAccountId(Long accountId) {
        return cardRepository.findAllByAccountId(accountId);
    }
}
