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
        for(int i = 0; i < data.length; i++){
            System.out.println("dato no: "+ i + " " +data[i]);
            // solicion posiblemente usando pattern y mattern
        }
        return new AccountStatement(
                data[NUMBER],
                data[KIND],
                data[BALANCE],
                data[INTEREST]
        );
    }
}
