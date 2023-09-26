package com.example.moneytransferservice.controller;

import com.example.moneytransferservice.information.Cards;
import com.example.moneytransferservice.information.ConfirmationRequest;
import com.example.moneytransferservice.information.UsersCard;
import com.example.moneytransferservice.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    TransferService service;

    @PostMapping("/transfer")
    public ResponseEntity<?> getDescription(@RequestBody Cards request) {
        try {
            List<UsersCard> result = service.performTransfer(request);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("message", e.getMessage()));
        }
    }

    @PostMapping("/confirmOperation")
    public void confirmOperation(@RequestBody ConfirmationRequest confirmationRequest) {

    }
}
