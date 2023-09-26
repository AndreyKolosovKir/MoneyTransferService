package com.example.moneytransferservice.controller;

import com.example.moneytransferservice.information.Cards;
import com.example.moneytransferservice.information.ConfirmationRequest;
import com.example.moneytransferservice.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class Controller {
    @Autowired
    TransferService service;

    @PostMapping("/transfer")
    public String getDescription(@RequestBody Cards request) {
            String operationId = String.valueOf(service.performTransfer(request));
            return operationId;
    }

    @PostMapping("/confirmOperation")
    public void confirmOperation(@RequestBody ConfirmationRequest confirmationRequest) {

    }
}
