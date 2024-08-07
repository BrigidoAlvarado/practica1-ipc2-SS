package com.ipc2ss.cardmanager.backend.readers;

import com.ipc2ss.cardmanager.backend.dataCard.CardData;
import com.ipc2ss.cardmanager.backend.dataCard.Query.ListCards;
import com.ipc2ss.cardmanager.backend.exception.CardManagerException;

public class ListCardsReader extends  InfoReader{

    private static final int KIND = 0;
    private static final int AMOUNT = 1;
    private static final int START_DATE = 2;
    private static final int END_DATE = 3;
    private static final int ESTATE = 4;
    private static final int MAX = 5;
    private static final int MAX_NULL = 4;
    @Override
    public CardData read(String text) throws CardManagerException {

        String[] data = text.split(COMMA,5);
        /////
        System.out.println(data.length);
        for(int i = 0; i < data.length; i++){
            System.out.println(i+data[i]);
        }
        ListCards cards = new ListCards();

        cards.setAmount((data[AMOUNT]));
        cards.setKind(data[KIND]);
        cards.setEndDate(data[END_DATE]);
        cards.setStartDate(data[START_DATE]);

        if(data.length == MAX) {
            cards.setState(data[ESTATE]);
        } else if(data.length == MAX_NULL) {
            cards.setState(null);
        } else {
            throw new CardManagerException("Formato invalido");
        }
        return cards;
    }
}
