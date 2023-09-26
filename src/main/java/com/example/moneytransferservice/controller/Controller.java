package com.example.moneytransferservice.controller;

import com.example.moneytransferservice.exception.CustomException400;
import com.example.moneytransferservice.exception.CustomException500;
import com.example.moneytransferservice.information.Cards;
import com.example.moneytransferservice.information.ConfirmationRequest;
import com.example.moneytransferservice.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> getDescription(@RequestBody Cards request) {
        //TODO подумать как ввести отлов и вывод 400 и 500 ошибок
//        try {
            String operationId = String.valueOf(service.performTransfer(request));
            Map<String, String> response = new HashMap<>();
            response.put("operationId", operationId);
            return ResponseEntity.ok(response);
//        } catch (CustomException400 e) {
//            Map<String, Object> errorResponse = new HashMap<>();
//            errorResponse.put("message", "Error customer message");
//            errorResponse.put("id", 400);
//            return ResponseEntity.badRequest().body(errorResponse);
//        } catch (CustomException500 e) {
//            Map<String, Object> errorResponse = new HashMap<>();
//            errorResponse.put("message", e.getMessage());
//            errorResponse.put("id", 500);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//        }
    }

    @PostMapping("/confirmOperation")
    public ResponseEntity<?> confirmOperation(@RequestBody ConfirmationRequest confirmationRequest) {
            String operationId = String.valueOf(confirmationRequest.getOperationId());
            Map<String, String> response = new HashMap<>();
            response.put("operationId", operationId);
            return ResponseEntity.ok(response);
    }
}
