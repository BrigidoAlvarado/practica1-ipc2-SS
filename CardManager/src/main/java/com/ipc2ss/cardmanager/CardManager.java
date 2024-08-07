/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ipc2ss.cardmanager;

import com.ipc2ss.cardmanager.backend.exception.CardManagerException;
import com.ipc2ss.cardmanager.backend.readers.TxtReader;

import java.io.IOException;


/**
 *
 * @author brigidoalvarado
 */
public class CardManager {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        TxtReader reader = new TxtReader();
        try {
            reader.read("/home/brigidoalvarado/Documentos/prueba.txt");
        } catch (CardManagerException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

}

