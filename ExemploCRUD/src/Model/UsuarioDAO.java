/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Optional;

/**
 *
 * @author macig
 */
public class UsuarioDAO {

    public void add(String name, String username, String password) {
        String sql = "INSERT INTO usuario(nome, username, password) VALUES(?,?,?)";
        try (Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, username);
            stmt.setString(3, password);
            stmt.executeUpdate();
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Usuario> getAll() {
        ArrayList<Usuario> usuarios = new ArrayList();
        String sql = "SELECT id, nome, username, password FROM usuario";
        try (Connection conn = DAO.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario u = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("username"), rs.getString("password"));
                usuarios.add(u);
            }
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return usuarios;
    }
    
    public Optional<Usuario> getById(int id){
        String sql = "SELECT id, nome, username, password FROM usuario WHERE id = ?";
        try(Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Usuario u = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("username"), rs.getString("password"));
                return Optional.of(u);
            }
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }
    
    public ArrayList<Usuario> getByName(String nome){
        ArrayList<Usuario> usuarios = new ArrayList();
        String sql = "SELECT id, nome, username, password FROM usuario WHERE nome LIKE(?)";
        try(Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome + "%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Usuario u = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("username"), rs.getString("password"));
                usuarios.add(u);
            }
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return usuarios;
    }
    
    public boolean delete(int id){
        String sql = "DELETE FROM usuario WHERE id = ?";
        try(Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean update(int id, String nome, String username, String password){
        String sql = "UPDATE usuario SET nome = ?, username = ?, password = ? WHERE id = ?";
        try(Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, username);
            stmt.setString(3, password);
            stmt.setInt(4, id);
            return stmt.executeUpdate() > 0;
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}