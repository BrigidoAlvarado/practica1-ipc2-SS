package com.ipc2ss.cardmanager.backend.readers;

import com.ipc2ss.cardmanager.backend.dataCard.CardData;
import com.ipc2ss.cardmanager.backend.dataCard.Query.Query;
import com.ipc2ss.cardmanager.backend.exception.CardManagerException;

public class QueryReader extends InfoReader{

    private String numberCard;
    @Override
    public CardData read(String text) throws CardManagerException {
        numberCard = text;
        /////
        System.out.println(numberCard);
        return new Query(numberCard);
    }
}
