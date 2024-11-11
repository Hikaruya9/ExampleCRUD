/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Optional;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author macig
 */
public class ProdutoDAO {

    public void add(String nome, double valor) {
        String sql = "INSERT INTO produto(nome,valor) VALUES(?,?)";
        try (Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setDouble(2, valor);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Produto> getAll() {
        ArrayList<Produto> produtos = new ArrayList();
        String sql = "SELECT id,nome,valor FROM produto";
        try (Connection conn = DAO.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produto p = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getDouble("valor"));
                produtos.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return produtos;
    }

    public Optional<Produto> getById(int id) {
        String sql = "SELECT id,nome,valor FROM produto WHERE id = ?";
        try (Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Produto p = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getDouble("valor"));
                return Optional.of(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }
    
    public ArrayList<Produto> getByName(String nome) {
        ArrayList<Produto> produtos = new ArrayList();
        String sql = "SELECT id,nome,valor FROM produto WHERE nome LIKE?";
        try(Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%"+nome+"%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Produto p = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getDouble("valor"));
                produtos.add(p);
            }
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return produtos;
    }
    
    public boolean delete(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";
        try(Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean update(int id, String nome, double valor) {
        String sql = "UPDATE produto SET nome = ?, valor = ? WHERE id = ?";
        try(Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setDouble(2, valor);
            stmt.setInt(3, id);
            return stmt.executeUpdate() > 0;
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ArrayList<Produto> getByMinPrice(double minPrice) {
        ArrayList<Produto> produtos = new ArrayList();
        String sql = "SELECT id,nome,valor FROM produto WHERE valor >= ?";
        try(Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, minPrice);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Produto p = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getDouble("valor"));
                produtos.add(p);
            }
        }catch(SQLException e) {
                System.out.println(e.getMessage());
        }
        return produtos;
    }
    
    public ArrayList<Produto> getByMaxPrice(double maxPrice) {
        ArrayList<Produto> produtos = new ArrayList();
        String sql = "SELECT id,nome,valor FROM produto WHERE valor <= ?";
        try(Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, maxPrice);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Produto p = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getDouble("valor"));
                produtos.add(p);
            }
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return produtos;
    }
    
    public ArrayList<Produto> getByPriceBetween(double minPrice, double maxPrice) {
        ArrayList<Produto> produtos = new ArrayList();
        String sql = "SELECT id,nome,valor FROM produto WHERE valor >= ? AND valor <= ?";
        try(Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, minPrice);
            stmt.setDouble(2, maxPrice);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Produto p = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getDouble("valor"));
                produtos.add(p);
            }
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return produtos;
    }
}