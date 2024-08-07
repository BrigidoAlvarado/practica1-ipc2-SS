package com.ipc2ss.cardmanager.backend.readers;

import com.ipc2ss.cardmanager.backend.dataCard.CardData;
import com.ipc2ss.cardmanager.backend.dataCard.CardOperations.Cancelation;
import com.ipc2ss.cardmanager.backend.exception.CardManagerException;

public class CancelationReader extends InfoReader{
    @Override
    public CardData read(String text) throws CardManagerException {
        return new Cancelation(text);
    }
}
