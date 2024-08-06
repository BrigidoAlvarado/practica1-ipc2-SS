/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipc2ss.cardmanager.backend.readers;

import com.ipc2ss.cardmanager.backend.dataCard.CardData;
import com.ipc2ss.cardmanager.enums.TextTypes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.ipc2ss.cardmanager.enums.TextTypes.*;

/**
 *
 * @author brigidoalvarado
 */
public class TxtReader {

    private static final String WORD = "\\w+";
    private static final String START_PRT = "\\(";
    private static final String END_PRT = "\\)";
    private static final String CONTENT = ".*";
    private static final String END_FORMAT = ";";
    private static final Pattern pattern = Pattern.compile("^"+WORD+START_PRT+CONTENT+END_PRT+END_FORMAT+"$");

    private String keyWord;
    private String complement;

    public void readTxt(String txtPath) throws FileNotFoundException, IOException{

        try (BufferedReader bufferedReader = new BufferedReader( new FileReader(txtPath));){

            String readText;
            while ( (readText = bufferedReader.readLine()) != null){
                validateFormat(readText);
            }

            try {
                TextTypes type = TextTypes.valueOf(keyWord);
                readOption(type);
            } catch (IllegalArgumentException e){
                System.out.println("error en el formato");
            }


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

    private void readOption(TextTypes type){

        switch (type) {
            case TextTypes.SOLICITUD: System.out.println(SOLICITUD);
                break;
            case MOVIMIENTO: System.out.println(MOVIMIENTO);
                break;
            case ESTADO_CUENTA: System.out.println(ESTADO_CUENTA);
                break;
            case CONSULTAR_TARJETA: System.out.println(CONSULTAR_TARJETA);
                break;
            case CANCELACION_TARJETA: System.out.println(CANCELACION_TARJETA);
                break;
            case LISTADO_SOLICITUDES: System.out.println(LISTADO_SOLICITUDES);
                break;
            case AUTORIZACION_TARJETA: System.out.println(AUTORIZACION_TARJETA);
                break;
        }
    }

}




