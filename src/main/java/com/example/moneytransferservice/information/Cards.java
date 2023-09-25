package com.example.moneytransferservice.information;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cards {
    @JsonProperty("cardFromNumber")
    private String cardFromNumber;

    @JsonProperty("cardFromValidTill")
    private String cardFromValidTill;

    @JsonProperty("cardFromCVV")
    private String cardFromCVV;

    @JsonProperty("cardToNumber")
    private String cardToNumber;

    @JsonProperty("amount")
    private Amount amount;

    public String getCardFromNumber() {
        return cardFromNumber;
    }

    public void setCardFromNumber(String cardFromNumber) {
        this.cardFromNumber = cardFromNumber;
    }

    public String getCardToNumber() {
        return cardToNumber;
    }

    public void setCardToNumber(String cardToNumber) {
        this.cardToNumber = cardToNumber;
    }

    public String getCardFromValidTill() {
        return cardFromValidTill;
    }

    public void setCardFromValidTill(String cardFromValidTill) {
        this.cardFromValidTill = cardFromValidTill;
    }

    public String getCardFromCVV() {
        return cardFromCVV;
    }

    public void setCardFromCVV(String cardFromCVV) {
        this.cardFromCVV = cardFromCVV;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }
}
