package com.example.moneytransferservice.controller;

import com.example.moneytransferservice.information.Cards;
import com.example.moneytransferservice.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    TransferService service;

    @PostMapping("/transfer")
    public void getDescription(@RequestBody Cards request) {
        service.getSolutionOnTranslation(request);
    }
}
