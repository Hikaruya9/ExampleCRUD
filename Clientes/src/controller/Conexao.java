/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/dbclients";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try{
                //Carregar o driver JDBC para MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL,USER,PASSWORD);
                connection.setAutoCommit(false);
            }catch(ClassNotFoundException | SQLException e){
                System.out.println("Erro na coxão ao banco de dados");
                e.printStackTrace();
            }
        }
        return connection;
    }
}