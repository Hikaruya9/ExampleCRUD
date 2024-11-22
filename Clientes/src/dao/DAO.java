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
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
            pst.setString(i++, client.getName());
            pst.setString(i++, client.getCpfCnpj());
            pst.setString(i++, client.getEmail());
            pst.setString(i++, client.getPhoneNumber());
            pst.setString(i++, client.getAdress());
            pst.execute();
            connection.commit();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            closeConnection();
        }
    }

    public ArrayList<Client> listClients(){
        Connection connection = (Connection) Conexao.getConn();
        ArrayList<Client> clients = new ArrayList();
        try{
            pst = connection.prepareStatement(LIST_CLIENTS);
            rs = pst.executeQuery();
            while(rs.next()){
                clients.add(new Client(rs.getString("ID"), rs.getString("Name"), rs.getString("CpfCnpj"), rs.getString("Email"), rs.getString("PhoneNumber"), rs.getString("Adress")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            closeConnection();
        }
    }
    
    private void closeConnection() {
        
    }    
}