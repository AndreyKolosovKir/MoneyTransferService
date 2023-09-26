package com.example.moneytransferservice.controller;

import com.example.moneytransferservice.information.Cards;
import com.example.moneytransferservice.information.ConfirmationRequest;
import com.example.moneytransferservice.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {
    @Autowired
    TransferService service;

    @PostMapping("/transfer")
    public ResponseEntity<Map<String, String>> getDescription(@RequestBody Cards request) {
        String operationId = String.valueOf(service.performTransfer(request));
        Map<String, String> response = new HashMap<>();
        response.put("operationId", operationId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/confirmOperation")
    public ResponseEntity<Map<String, String>> confirmOperation(@RequestBody ConfirmationRequest confirmationRequest) {
        String operationId = String.valueOf(confirmationRequest.getOperationId());
        Map<String, String> response = new HashMap<>();
        response.put("operationId", operationId);
        return ResponseEntity.ok(response);
    }
}
