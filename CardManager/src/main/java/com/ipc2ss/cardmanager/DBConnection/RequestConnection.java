package com.ipc2ss.cardmanager.DBConnection;

import com.ipc2ss.cardmanager.backend.dataCard.Request;
import com.ipc2ss.cardmanager.backend.exception.CardManagerException;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class RequestConnection extends DBConnection{

    private static Request request;

    public static void saveRequest(Request rq) throws CardManagerException {

        getConnection();
        request = rq;
        String sqlInsert = "insert into request (number, date, kind, name, salary, address) " +
                "values ("
                      + rq.getNumber() +
                ","   + rq.getDate() +
                ", '" + rq.getKind() + "'" +
                ", "  + rq.getName() +
                ", "  + rq.getSalary() +
                ", "  + rq.getAddress() +");";
        System.out.println(sqlInsert);
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sqlInsert);
        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            throw new CardManagerException("Este numero de solcitud ya se encuentra cargado en la base de datos \nrevise sus valores de entrada");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CardManagerException("Error al cargar los datos de la solicitud a la base de datos");
        }
    }
}
