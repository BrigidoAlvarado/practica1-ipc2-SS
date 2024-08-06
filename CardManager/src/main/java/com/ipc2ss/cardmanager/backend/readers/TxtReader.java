/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipc2ss.cardmanager.backend.readers;

import com.ipc2ss.cardmanager.backend.dataCard.CardData;
import com.ipc2ss.cardmanager.enums.TextTypes;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;

import static com.ipc2ss.cardmanager.enums.TextTypes.*;

/**
 *
 * @author brigidoalvarado
 */
public class TxtReader extends InfoReader{

    private String keyWord;
    private String complement;

    @Override
    public List<CardData> read(String txtPath) throws FileNotFoundException, IOException{

        try (BufferedReader bufferedReader = new BufferedReader( new FileReader(txtPath));){

            String readText;
            while ( (readText = bufferedReader.readLine()) != null){
                validateFormat(readText);
            }

            try {
                TextTypes type = TextTypes.valueOf(keyWord);
                return readOption(type);
            } catch (IllegalArgumentException e){
                System.out.println("error en el formato");
                return null;
            }
         }
    }

    @Override
    protected void validateFormat(String readText){

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

    private List<CardData> readOption(TextTypes type){

        switch (type) {
            case TextTypes.SOLICITUD: System.out.println(SOLICITUD); return null;
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
        return null;
    }

}




