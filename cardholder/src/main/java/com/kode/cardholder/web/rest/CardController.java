package com.kode.cardholder.web.rest;

import com.kode.cardholder.domain.Card;
import com.kode.cardholder.dto.NewCardInfoDTO;
import com.kode.cardholder.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/{accountId}/cards")
    public ResponseEntity<Void> createCard(@PathVariable Long accountId, @RequestBody @Validated NewCardInfoDTO newCardInfo) {
        Long cardId = cardService.createNewCard(accountId, newCardInfo);

        if (cardId != null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{accountId}/cards")
    public ResponseEntity<List<Card>> findAll(@PathVariable Long accountId) {
        return ResponseEntity.ok()
            .body(cardService.findAllByAccountId(accountId));
    }
}
