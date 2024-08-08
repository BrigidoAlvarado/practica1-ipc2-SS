package com.ipc2ss.cardmanager.backend.dataCard.Query;

import com.ipc2ss.cardmanager.backend.dataCard.CardData;
import com.ipc2ss.cardmanager.backend.exception.CardManagerException;
import com.ipc2ss.cardmanager.enums.BooleanTypes;
import com.ipc2ss.cardmanager.enums.CardsTypes;

public class RequestsList extends CardData {

    private String startDate;
    private String endDate;
    private String kind;
    private double amount;
    private String state;

    public void setStartDate(String startDate) {
        if (startDate != "") {
            //////
            System.out.println("se ejecuta " + startDate);
            this.startDate = super.transformationDate(startDate);
        }

    }

    public void setEndDate(String endDate) {
        if (endDate != "") {
            this.endDate = super.transformationDate(endDate);
        }

        System.out.println("startDate " + startDate + " endDate " + endDate + " kind " + kind + " amount " + amount + " state " + state);
    }

    public void setKind(String kind) throws CardManagerException {

        try {
            if (kind.equalsIgnoreCase(CardsTypes.valueOf(kind).name())){
                this.kind = kind;
            }
        }catch(IllegalArgumentException e) {
            if (!kind.equalsIgnoreCase("")){
                throw new CardManagerException("Tipo de tarjeta invalido: " + kind);
            }
        }
    }

    public void setAmount(String amount) {
        try {
            this.amount = Double.parseDouble(amount);
        } catch (NumberFormatException e) {
            if (amount.equalsIgnoreCase("")) {
                this.amount = 0;
            } else{
                throw new NumberFormatException("Invalido monto " + amount);
            }
        }
    }

    public void setState(String state) {

        try {
            switch (BooleanTypes.valueOf(state)) {
                case APROBADA:
                    this.state = TRUE;
                    break;
                case CANCELADA:
                        this.state = FALSE;
                        break;
            }
        } catch (IllegalArgumentException e) {
            if (state.equalsIgnoreCase("")) {
                this.state = TRUE_OR_FALSE;
            } else{
                throw new NumberFormatException("Estado invalido " + state);
            }
        }
    }
}
