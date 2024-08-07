package com.ipc2ss.cardmanager.backend.dataCard.CardOperations;

import com.ipc2ss.cardmanager.backend.dataCard.CardData;

public class Authorization extends CardData {
    private double limit;
    private int number;

    public Authorization(int number) {
        this.number = number;
        System.out.println(number);
    }
}

