/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ipc2ss.cardmanager;

import com.ipc2ss.cardmanager.backend.readers.TxtReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author brigidoalvarado
 */
public class CardManager {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        TxtReader reader = new TxtReader();
        try {
            reader.readTxt("/home/brigidoalvarado/Documentos/prueba.txt");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());;
        }
    }

}

