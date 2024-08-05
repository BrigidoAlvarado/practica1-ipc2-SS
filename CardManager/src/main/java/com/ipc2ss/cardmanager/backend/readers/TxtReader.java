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

/**
 *
 * @author brigidoalvarado
 */
public class TxtReader {
    
    private String txtPath;
    private String option;
    
    public List <CardData> readTxt() throws FileNotFoundException, IOException{
        
        File txtFile = new File (txtPath);
        
        try (FileReader filereader = new FileReader(txtFile);
                BufferedReader bufferedReader = new BufferedReader( filereader);
                ){
                    while ((option = bufferedReader.readLine()) != null){
                        
                        
            }
        }
        return null;
    }
        
}
