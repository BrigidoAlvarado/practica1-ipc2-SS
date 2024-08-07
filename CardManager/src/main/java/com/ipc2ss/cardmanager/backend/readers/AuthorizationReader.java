package com.ipc2ss.cardmanager.backend.readers;

import com.ipc2ss.cardmanager.backend.dataCard.CardData;
import com.ipc2ss.cardmanager.backend.dataCard.CardOperations.Authorization;
import com.ipc2ss.cardmanager.backend.exception.CardManagerException;

public class AuthorizationReader extends  InfoReader{


    @Override
    public CardData read(String text) throws CardManagerException {
        Authorization authorization = new Authorization(Integer.parseInt(text));
        return authorization;

    }
}
