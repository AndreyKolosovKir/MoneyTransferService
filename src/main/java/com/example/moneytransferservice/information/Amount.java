package com.example.moneytransferservice.information;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Amount {
    @JsonProperty("value")
    private int value;

    @JsonProperty("currency")
    private String currency;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
