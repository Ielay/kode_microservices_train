package com.kode.cardholder.web.rest;

import com.kode.cardholder.domain.Card;
import com.kode.cardholder.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/{accountId}/cards")
    public ResponseEntity<List<Card>> findAll(@PathVariable Long accountId) {
        return ResponseEntity.ok()
            .body(cardService.findAllByAccountId(accountId));
    }
}
