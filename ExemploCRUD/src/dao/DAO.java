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
import model.User;
/**
 *
 * @author Aluno
 */
public class DAO {
    private static PreparedStatement pst = null;
    private static ResultSet rs = null;
    
//    private static String CREATE_CLIENT = "INSERT INTO client(name,cpfCnpj,email,phoneNumber,adress) VALUES(?,?,?,?,?)";
    private static String RETRIEVE_CLIENT = "SELECT id,name,cpfCnpj,email,phoneNumber,adress FROM client WHERE id = ?";
    private static String UPDATE_CLIENT = "UPDATE client SET name = ?,cpfCnpj = ?,email = ?,phoneNumber = ?,adress = ? WHERE id = ?";
    private static String DELETE_CLIENT = "DELETE FROM client WHERE id = ?";
    private static String LIST_CLIENTS = "SELECT id,name,cpfCnpj,email,phoneNumber,adress FROM client";
    private static String RETRIEVE_USER = "SELECT id,username,password FROM user WHERE username = ? AND passowrd = ?";
    
    public void createClient(Client client){
        String sql = "INSERT INTO client(name,cpfCnpj,email,phoneNumber,adress) VALUES(?,?,?,?,?)";
        try(Connection connection = Conexao.getConnection(); PreparedStatement pst = connection.prepareStatement(sql)){
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
        }
    }
    
    public Client retrieveClient(String id) throws Exception{
        Connection connection = Conexao.getConnection();
        Client client = null;
        try{
            pst = connection.prepareStatement(RETRIEVE_CLIENT);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if(rs.next()){
                client = new Client(rs.getString("ID"), rs.getString("Name"), rs.getString("CpfCnpj"), rs.getString("Email"), rs.getString("PhoneNumber"), rs.getString("Adress"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        if(client==null){
            JOptionPane.showMessageDialog(null,"Não foi encontrado nenhum cliente!", "", JOptionPane.WARNING_MESSAGE);
            throw new Exception("Não foi encontrado nenhum cliente!");
        }
        return client;
    }
    
    public void updateClient(String id, Client client){
        Connection connection = Conexao.getConnection();
        try{
            pst = connection.prepareStatement(UPDATE_CLIENT);
            int i = 1;
            pst.setString(i++, client.getName());
            pst.setString(i++, client.getCpfCnpj());
            pst.setString(i++, client.getEmail());
            pst.setString(i++, client.getPhoneNumber());
            pst.setString(i++, client.getAdress());
            pst.setString(i++, id);
            pst.execute();
            connection.commit();
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void deleteClient(String id){
        Connection connection = Conexao.getConnection();
        try{
            pst = connection.prepareStatement(DELETE_CLIENT);
            pst.setString(1, id);
            pst.execute();
            connection.commit();
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Client> listClients() throws Exception{
        Connection connection = (Connection) Conexao.getConnection();
        ArrayList<Client> clients = new ArrayList();
        try{
            pst = connection.prepareStatement(LIST_CLIENTS);
            rs = pst.executeQuery();
            while(rs.next()){
                clients.add(new Client(rs.getString("ID"), rs.getString("Name"), rs.getString("CpfCnpj"), rs.getString("Email"), rs.getString("PhoneNumber"), rs.getString("Adress")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        if(clients.isEmpty()){
            JOptionPane.showMessageDialog(null, "Não há clientes cadastrados!", "", JOptionPane.WARNING_MESSAGE);
            throw new Exception("Não há clientes cadastrados!");
        }
        return clients;
    }
    
    public User retrieveUser(String username, String passwordEncrypted) throws Exception{
        Connection connection = Conexao.getConnection();
        User user = null;
        try{
            pst = connection.prepareStatement(RETRIEVE_USER);
            pst.setString(1, username);
            pst.setString(2, passwordEncrypted);
            rs = pst.executeQuery();
            if(rs.next()){
                user = new User(rs.getInt("ID"), rs.getString("Username"), rs.getString("Password"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        if(user==null){
            JOptionPane.showMessageDialog(null, "Usuário não existe!", "", JOptionPane.WARNING_MESSAGE);
            throw new Exception("Usuário não existe!");
        }
        return user;
    }
    
    /*private void closeConnection() { 
        try{
            if(rs!=null)rs.close();
            if(pst!=null)pst.close();
            Conexao.getConnection();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }*/    
}