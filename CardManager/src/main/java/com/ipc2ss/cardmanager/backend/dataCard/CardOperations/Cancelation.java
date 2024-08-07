package com.ipc2ss.cardmanager.backend.dataCard.CardOperations;

import com.ipc2ss.cardmanager.backend.dataCard.CardData;

public class Cancelation extends CardData {

    private String cardNumber;

    public Cancelation(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
