package com.ipc2ss.cardmanager.backend.readers;

import com.ipc2ss.cardmanager.backend.dataCard.CardData;
import com.ipc2ss.cardmanager.backend.dataCard.Query.AccountStatement;
import com.ipc2ss.cardmanager.backend.exception.CardManagerException;

public class AccountStatementReader extends InfoReader {

    private static final int NUMBER = 0;
    private static final int KIND = 1;
    private static final int BALANCE = 2;
    private static final int INTEREST = 3;

    private String number;
    private String kind;
    private double balance;
    private double interest;


    @Override
    public CardData read(String text) throws CardManagerException {
        String[] data = text.split(COMMA);

        if(data.length == 4){
            return new AccountStatement(
                    data[NUMBER],
                    data[KIND],
                    data[BALANCE],
                    data[INTEREST]
            );
        } else if (data.length == 3) {
            return new AccountStatement(
                    data[NUMBER],
                    data[KIND],
                    data[BALANCE],
                    "0"
            );
        } else {
            throw new CardManagerException("Formato invalido ");
        }
    }
}
