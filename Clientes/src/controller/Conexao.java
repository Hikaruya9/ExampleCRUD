/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class Conexao {

    private static final String url = "jbdc:mysql://localhost:3306/dbclients";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection connection;
    private static Conexao conn;

    public static Conexao getConn() {
        if (conn == null) {
            conn = new Conexao();
        }
        return conn;
    }

    public Connection openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error to set connection to Database");
        }
        return null;
    }

    public void closeConnection() {
        try {
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error to close connection to Database " + e.getMessage());
        }finally{
            connection = null;
        }
    }
}