/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipc2ss.cardmanager.backend.dataCard;

/**
 *
 * @author brigidoalvarado
 */
public class CardData {

    private static final Character QUOTATION_MARK = '\"';
    private static final String SLASH = "/";
    private static final int DAY = 0;
    private static final int MONTH = 1;
    private static final int YEAR = 2;

    protected String date;

    protected void transformationDate(){
        date = date.substring(1,date.length()-1);
        String[] oldDate = date.split(SLASH);
        date = QUOTATION_MARK + oldDate[YEAR] + SLASH + oldDate[MONTH] + SLASH + oldDate[DAY] + QUOTATION_MARK;
        System.out.println(date);
    }
}
