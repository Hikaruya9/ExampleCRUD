/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author macig
 */
public class DAO {

    private static final String URL = "jdbc:mysql://localhost:3306/exemplo_crud";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        }catch(SQLException e){
            System.out.println("Problemas ao conectar em: "+ e.getMessage());
        }
        return connection;
    }

}
