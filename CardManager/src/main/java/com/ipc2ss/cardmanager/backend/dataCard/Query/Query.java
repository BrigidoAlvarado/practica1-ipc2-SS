package com.ipc2ss.cardmanager.backend.dataCard.Query;

import com.ipc2ss.cardmanager.backend.dataCard.CardData;

public class Query extends CardData {

    private String cardNumber;
    private String endPath;

    public Query(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public void createHTML (String endPath){
        this.endPath = endPath;
    }
}
