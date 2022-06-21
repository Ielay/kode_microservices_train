package com.kode.cardholder.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //FK
    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Column(name = "card_number", nullable = false, unique = true)
    private String cardNumber;

    @Column(name = "ccv", nullable = false)
    private String ccv;

    @Temporal(TemporalType.DATE)
    @Column(name = "valid_through", nullable = false)
    private Date validThrough;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public Date getValidThrough() {
        return validThrough;
    }

    public void setValidThrough(Date validThrough) {
        this.validThrough = validThrough;
    }
}
