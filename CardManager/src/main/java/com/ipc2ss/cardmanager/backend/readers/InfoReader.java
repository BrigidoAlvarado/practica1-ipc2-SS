package com.ipc2ss.cardmanager.backend.readers;

import com.ipc2ss.cardmanager.backend.dataCard.CardData;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

    public abstract class InfoReader {

    protected static final String WORD = "\\w+";protected static final String START_PRT = "\\(";
    protected static final String END_PRT = "\\)";
    protected static final String CONTENT = ".*";
    protected static final String END_FORMAT = ";";
    protected static final Pattern pattern = Pattern.compile("^"+WORD+START_PRT+CONTENT+END_PRT+END_FORMAT+"$");

    public abstract List<CardData> read (String txtPath) throws FileNotFoundException, IOException;

    protected abstract void validateFormat(String readText);
}
