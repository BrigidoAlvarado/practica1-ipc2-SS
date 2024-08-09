package com.ipc2ss.cardmanager.DBConnection;

import com.ipc2ss.cardmanager.backend.exception.CardManagerException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static final String HOST = "localhost";
    public static final String PORT = "3306";
    public static final String DATABASE = "card_control";
    public static final String USER = "root";
    public static final String PASSWORD = "1234";
    public static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;

    protected static Connection connection;

    protected static void getConnection() throws CardManagerException {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL,USER,PASSWORD);
            } catch (SQLException e){
                e.printStackTrace();
                throw new CardManagerException("Error al crear la coneccion");
            }
        }
    }
}
