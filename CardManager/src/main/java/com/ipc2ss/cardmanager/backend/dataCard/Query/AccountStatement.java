package com.ipc2ss.cardmanager.backend.dataCard.Query;

import com.ipc2ss.cardmanager.backend.dataCard.CardData;

public class AccountStatement extends CardData {

    private String number;
    private String kind;
    private double balance;
    private double interest;

    public AccountStatement(String number, String kind, String balance, String interest) {
        this.number = number;
        this.kind = kind;
        if (balance != null){
            this.balance = Double.parseDouble(balance);
        } else {
            this.balance = 0;
        }
        if (interest != null){
            this.interest = Double.parseDouble(interest);
        } else {
            this.interest = 0;
        }
        System.out.println(number + " " + kind + " " + balance + " " + interest);
    }
}
