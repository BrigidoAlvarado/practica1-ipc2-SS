package com.ipc2ss.cardmanager.backend.readers;

import com.ipc2ss.cardmanager.backend.dataCard.CardData;
import com.ipc2ss.cardmanager.backend.dataCard.Transaction;
import com.ipc2ss.cardmanager.backend.exception.CardManagerException;
import com.ipc2ss.cardmanager.enums.TransactionTypes;

public class TransactionReader extends InfoReader {


    private static final int CARD_NUMBER = 0;
    private static final int DATE = 1;
    private static final int KIND = 2;
    private static final int DESCRIPTION = 3;
    private static final int ESTABLISMENT = 4;
    private static final int AMOUNT = 5;
    private static final int NUMBER_DATA = 6;

    private String cardNumber;
    private String date;
    private String kind;
    private String description;
    private String establishment;
    private double amount;

    @Override
    public CardData read(String text) throws CardManagerException {

        String[] data = text.split(COMMA);
        /////////////////////////////////////
        for(int i = 0; i < data.length; i++){
            System.out.println(data[i]);
        }
        ////////////////////////////////////
        if (data.length == NUMBER_DATA) {
            ///////////////////
            System.out.println(data.length+" "+NUMBER_DATA);
            date = data[DATE];
            kind = data[KIND];
            description = data[DESCRIPTION];
            amount = Double.parseDouble(data[AMOUNT]);
            cardNumber = data[CARD_NUMBER];
            establishment = data[ESTABLISMENT];
            return addData();
        } else {
            ////////////
            System.out.println("holi");
            throw new CardManagerException("Formato invalido revise los valores dentro de los parentesis");
        }
    }

    private CardData addData()throws CardManagerException{
        Transaction transaction = new Transaction();
        transaction.setCardNumber(cardNumber);
        transaction.setDate(date);
        if (kind.equalsIgnoreCase(TransactionTypes.valueOf(kind).name())){
            transaction.setKind(kind);
        } else {
            throw new CardManagerException("El tipo de transaccion no es valido, revise los valores por favor");
        }
        transaction.setDescription(description);
        transaction.setEstablishment(establishment);
        transaction.setAmount(amount);
        return transaction;
    }

}
