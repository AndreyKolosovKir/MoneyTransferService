package com.example.moneytransferservice.information;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConfirmationRequest {
    @JsonProperty("operationId")
    private Long operationId;
    @JsonProperty("code")
    private String secretCode;

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }


}
