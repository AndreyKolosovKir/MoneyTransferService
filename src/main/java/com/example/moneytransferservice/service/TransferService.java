package com.example.moneytransferservice.service;

import com.example.moneytransferservice.information.Amount;
import com.example.moneytransferservice.information.Cards;
import com.example.moneytransferservice.information.UsersCard;
import com.example.moneytransferservice.loger.Logger;
import com.example.moneytransferservice.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransferService {

    @Autowired
    CardsRepository repository;

    @Autowired
    Logger logger;

    public Long performTransfer(Cards request) {
        if (notEmpty(request) && notEmptyNull(request) && notEmptyAmount(request)) {

            UsersCard user1 = null;
            UsersCard user2 = null;
            user1.setUserNumberCard(request.getCardFromNumber());
            user2.setUserNumberCard(request.getCardToNumber());

            if (user1 == null || user2 == null) {
                throw new RuntimeException("Invalid card numbers");
            }

            user1.setAmountOfMoney(user1.getAmountOfMoney() - request.getAmount().getValue());
            user2.setAmountOfMoney(user2.getAmountOfMoney() + request.getAmount().getValue());

            List<UsersCard> dataUserInformation = new ArrayList<>();

            dataUserInformation.add(user1);
            dataUserInformation.add(user2);

            logger.logCardsRepositoryData(repository.putInformationCards(request), repository.putInformationTrans(request));
            logger.logServiceData(dataUserInformation);
            return repository.getIdTrans();
        }
        throw new RuntimeException("The user did not fill in all fields");
    }

    public boolean notEmpty(Cards request) {
        if (request.getCardToNumber().isEmpty() &&
                request.getCardFromNumber().isEmpty() &&
                request.getCardFromCVV().isEmpty() &&
                request.getCardFromValidTill().isEmpty()
        ) {
            return false;
        }
        return true;
    }

    public boolean notEmptyNull(Cards request) {
        if (request.getCardToNumber() == null &&
                request.getCardFromNumber() == null &&
                request.getCardFromCVV() == null &&
                request.getCardFromValidTill() == null
        ) {
            return false;
        }
        return true;
    }

    public boolean notEmptyAmount(Cards request) {
        Amount amount = request.getAmount();
        if (amount.getValue() == 0 &&
                amount.getCurrency().isEmpty() &&
                amount.getCurrency() == null) {
            return false;
        }
        return true;
    }
}
