package com.ipc2ss.cardmanager.backend.dataCard.Query;

import com.ipc2ss.cardmanager.backend.dataCard.CardData;
import com.ipc2ss.cardmanager.enums.BooleanTypes;

public class RequestsList extends CardData {

    private String startDate;
    private String endDate;
    private String kind;
    private double amount;
    private String state;

    public void setStartDate(String startDate) {
        this.startDate = super.transformationDate(startDate);
    }

    public void setEndDate(String endDate) {
        this.endDate = super.transformationDate(endDate);
        System.out.println("startDate " + startDate + " endDate " + endDate + " kind " + kind + " amount " + amount + " state " + state);
    }

    public void setKind(String kind) {
        if
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
