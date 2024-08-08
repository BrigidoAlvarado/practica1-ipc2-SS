package com.ipc2ss.cardmanager.backend.dataCard.Query;

import com.ipc2ss.cardmanager.backend.dataCard.CardData;
import com.ipc2ss.cardmanager.backend.exception.CardManagerException;
import com.ipc2ss.cardmanager.enums.StatesTypes;

public class CardsList extends CardData {

    private String kind;
    private double amount;
    private String startDate;
    private String endDate;
    private String state;

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setAmount(String amount) throws CardManagerException {
        ////////////////////
        System.out.println("el monto es de "+amount);
        if (amount != null) {
            try {
                this.amount = Double.parseDouble(amount);
            } catch (NumberFormatException e) {
                if (amount.equals("")) {
                    this.amount = 0;
                } else {
                    throw new CardManagerException("El valor del monto no es valido");
                }

            }
        }
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setState(String state) {

       try {
           switch (StatesTypes.valueOf(state)){
               case AUTORIZADA: this.state = TRUE;
               case CANCELADA: this.state = FALSE;
           }
       }catch (IllegalArgumentException e){
           this.state = TRUE_OR_FALSE;
       }



        System.out.println(kind + " " + amount + " " + startDate + " " + endDate + " " + state);
    }
}
