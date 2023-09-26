package com.example.moneytransferservice.repository;

import com.example.moneytransferservice.information.Amount;
import com.example.moneytransferservice.information.Cards;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CardsRepository {

    private Long idTrans = 0L;
    private final Map<Long, Cards> informationCards = new HashMap<>();
    private final Map<Long, Amount> informationTrans = new HashMap<>();

    public Map<Long, Cards> putInformationCards(Cards request) {
        if (idTrans == 0) {
            idTrans += 1;
        }

        putInformationTrans(request);
        informationCards.put(idTrans, request);
        return informationCards;
    }

    public Map<Long, Amount> putInformationTrans(Cards request) {
        informationTrans.put(idTrans, request.getAmount());
        return informationTrans;
    }

    public Long getIdTrans() {
        return idTrans;
    }

    public void setIdTrans(Long idTrans) {
        this.idTrans = idTrans;
    }
}
