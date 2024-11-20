/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controller.Conexao;
import model.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
/**
 *
 * @author Aluno
 */
public class DAO {
    private static PreparedStatement pst = null;
    private static ResultSet rs = null;
    
    private static String CREATE_CLIENT = "INSERT INTO client(name,cpfCnpj,email,phoneNumber,adress) VALUES(?,?,?,?,?)";
    private static String RETRIEVE_CLIENT = "SELECT id,name,cpfCnpj,email,phoneNumber,adress FROM client WHERE id = ?";
    private static String UPDATE_CLIENT = "UPDATE client SET name = ?,cpfCnpj = ?,email = ?,phoneNumber = ?,adress = ? WHERE id = ?";
    private static String DELETE_CLIENT = "DELETE FROM client WHERE id = ?";
    private static String LIST_CLIENTS = "SELECT id,name,cpfCnpj,email,phoneNumber,adress FROM client";
    private static String RETRIEVE_USER = "SELECT id,username,password FROM user WHERE username = ? AND passowrd = ?";
    
    public void createClient(Client client){
        Connection connection = Conexao.getConn().openConnection();
        try{
            pst.connection.prepareStatement(CREATE_CLIENT);
            int i = 1;
            
        }catch(Exception e){
            
        }
    }
    
}