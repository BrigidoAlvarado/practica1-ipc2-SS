package com.ipc2ss.cardmanager.backend.readers;

import com.ipc2ss.cardmanager.backend.dataCard.CardData;
import com.ipc2ss.cardmanager.backend.dataCard.Request;
import com.ipc2ss.cardmanager.backend.exception.CardManagerException;
import com.ipc2ss.cardmanager.enums.CardsTypes;

public class RequestReader extends InfoReader {

    private static final int NUMBER = 0;
    private static final int DATE = 1;
    private static final int KIND = 2;
    private static final int NAME = 3;
    private static final int SALARY = 4;
    private static final int ADDRESS = 5;
    private static final int NUMBER_DATA = 6;

    private String date;
    private String kind;
    private String address;
    private String name;
    private int number;
    private double salary;

    @Override
    public CardData read(String text) throws CardManagerException {

        String[] data = text.split(COMMA);
        /////////////////////////////////////
        for(int i = 0; i < data.length; i++){
            System.out.println(data[i]);
        }
        ////////////////////////////////////
        if (data.length == NUMBER_DATA) {
            //////////
            System.out.println(data.length+" "+NUMBER_DATA);
            date = data[DATE];
            kind = data[KIND];
            address = data[ADDRESS];
            number = Integer.parseInt(data[NUMBER]);
            salary = Double.parseDouble(data[SALARY]);
            name = data[NAME];
            return addData();
        } else {
            System.out.println("holi");
            throw new CardManagerException("Formato invalido revise los valores dentro de los parentesis");
        }

    }

    private CardData addData() throws CardManagerException {

        Request request = new Request();
        request.setDate(date);
        //Se comprueba si el tipo forma parte de los tipos disponibles de tarjeta
        if (kind.equals(CardsTypes.valueOf(kind).name())){
            request.setKind(kind);
        } else {
            throw new CardManagerException("Tipo de tarjeta invalido");
        }
        request.setAddress(address);
        request.setNumber(number);
        request.setSalary(salary);
        request.setName(name);
        return request;

    }
}
