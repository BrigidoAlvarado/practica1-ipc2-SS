/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipc2ss.cardmanager.backend.readers;

import com.ipc2ss.cardmanager.backend.dataCard.CardData;
import com.ipc2ss.cardmanager.backend.exception.CardManagerException;
import com.ipc2ss.cardmanager.enums.TextTypes;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.ipc2ss.cardmanager.enums.TextTypes.*;

/**
 *
 * @author brigidoalvarado
 */
public class TxtReader extends InfoReader{

    private static final String WORD = "\\w+";
    private static final String START_PRT = "\\(";
    private static final String END_PRT = "\\)";
    private static final String CONTENT = ".*";
    private static final String END_FORMAT = ";";
    private static final Pattern pattern = Pattern.compile("^"+WORD+START_PRT+CONTENT+END_PRT+END_FORMAT+"$");


    private String keyWord;
    private String complement;

    @Override
    public CardData read(String text) throws CardManagerException {

        try (BufferedReader bufferedReader = new BufferedReader( new FileReader(text))){

            String readText;
            while ( (readText = bufferedReader.readLine()) != null){
                validateFormat(readText);
            }

                TextTypes type = TextTypes.valueOf(keyWord);
                return readOption(type);

        } catch (IOException | IllegalArgumentException e){
            e.printStackTrace();
            throw new CardManagerException("Error al cargar el archivo");

        } catch (CardManagerException e){
            throw e;
        }
    }


    private void validateFormat(String readText){

        Matcher matcher = pattern.matcher(readText);
        if (matcher.matches()){
            String[] words = readText.split(START_PRT,2);
            if (words.length == 2){
                keyWord = words[0];
                String part2 = words[1];
                complement = part2.substring(0,part2.length()-2);

            } else{
                System.out.println("lanzar error");
            }
        }
        else {
            System.out.println("lanzar error");
        }

    }

    private CardData readOption(TextTypes type) throws CardManagerException{
        ///////////
        System.out.println("key word "+keyWord);
        System.out.println("complement "+complement);
        ///////////

        switch (type) {
            case TextTypes.SOLICITUD:
                RequestReader request = new RequestReader();
                return request.read(complement);
            case MOVIMIENTO: System.out.println(MOVIMIENTO);
                TransactionReader transaction = new TransactionReader();
                return transaction.read(complement);
            case ESTADO_CUENTA:
                AccountStatementReader account = new AccountStatementReader();
                return account.read(complement);
            case CONSULTAR_TARJETA:
                QueryReader query = new QueryReader();
                return query.read(complement);
            case CANCELACION_TARJETA:
                CancelationReader cancellation = new CancelationReader();
                return cancellation.read(complement);
            case LISTADO_SOLICITUDES:
                RequestListReader requestList = new RequestListReader();
                return requestList.read(complement);
            case AUTORIZACION_TARJETA:
                AuthorizationReader authorization = new AuthorizationReader();
                return authorization.read(complement);
            case LISTADO_TARJETAS:
                ListCardsReader cards = new ListCardsReader();
                return cards.read(complement);

        }
        return null;
    }

}




