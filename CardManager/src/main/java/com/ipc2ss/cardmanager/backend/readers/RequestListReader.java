package com.ipc2ss.cardmanager.backend.readers;

import com.ipc2ss.cardmanager.backend.dataCard.CardData;
import com.ipc2ss.cardmanager.backend.dataCard.Query.RequestsList;
import com.ipc2ss.cardmanager.backend.exception.CardManagerException;

public class RequestListReader extends InfoReader{

    private static final int START_DATE = 0;
    private static final int END_DATE = 1;
    private static final int KIND = 2;
    private static final int AMOUNT = 3;
    private static final int STATE = 4;
    private static final int MAX = 5;

    @Override
    public CardData read(String text) throws CardManagerException {

        String[] data = text.split(COMMA,MAX);
        RequestsList requestsList = new RequestsList();
        requestsList.setAmount(data[AMOUNT]);
        requestsList.setState(data[STATE]);
        requestsList.setKind(data[KIND]);
        requestsList.setStartDate(data[START_DATE]);
        requestsList.setEndDate(data[END_DATE]);
        return requestsList;
    }
}
