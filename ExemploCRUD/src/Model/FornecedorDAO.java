/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ArrayList;

/**
 *
 * @author macig
 */
public class FornecedorDAO {

    public void add(String razaoSocial, String nomeFantasia, String cnpj) {
        String sql = "INSERT INTO fornecedor(razao_social,nome_fantasia,cnpj) VALUES(?,?,?)";
        try (Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, razaoSocial);
            stmt.setString(2, nomeFantasia);
            stmt.setString(3, cnpj);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Fornecedor> getAll() {
        ArrayList<Fornecedor> fornecedores = new ArrayList();
        String sql = "SELECT id,razao_social,nome_fantasia,cnpj FROM fornecedor";
        try (Connection conn = DAO.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Fornecedor f = new Fornecedor(rs.getInt("id"), rs.getString("razao_social"), rs.getString("nome_fantasia"), rs.getString("cnpj"));
                fornecedores.add(f);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return fornecedores;
    }

    public Optional<Fornecedor> getById(int id) {
        String sql = "SELECT id,razao_social,nome_fantasia,cnpj FROM fornecedor WHERE id = ?";
        try (Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Fornecedor f = new Fornecedor(rs.getInt("id"), rs.getString("razao_social"), rs.getString("nome_fantasia"), rs.getString("cnpj"));
                return Optional.of(f);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }

    public ArrayList<Fornecedor> getByRazaoSocial(String razaoSocial) {
        ArrayList<Fornecedor> fornecedores = new ArrayList();
        String sql = "SELECT id,razao_social,nome_fantasia,cnpj FROM fornecedor WHERE razao_social LIKE(?)";
        try (Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + razaoSocial + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Fornecedor f = new Fornecedor(rs.getInt("id"), rs.getString("razao_social"), rs.getString("nome_fantasia"), rs.getString("cnpj"));
                fornecedores.add(f);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return fornecedores;
    }

    public ArrayList<Fornecedor> getByCnpj(String cnpj) {
        ArrayList<Fornecedor> fornecedores = new ArrayList();
        String sql = "SELECT id,razao_social,nome_fantasia,cnpj FROM fornecedor WHERE cnpj LIKE(?)";
        try (Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + cnpj + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Fornecedor f = new Fornecedor(rs.getInt("id"), rs.getString("razao_social"), rs.getString("nome_fantasia"), rs.getString("cnpj"));
                fornecedores.add(f);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return fornecedores;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM fornecedor WHERE id = ?";
        try (Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean update(int id, String razaoSocial, String nomeFantasia, String cnpj) {
        String sql = "UPDATE fornecedor SET razao_social = ?, nome_fantasia = ?, cnpj = ? WHERE id = ?";
        try (Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, razaoSocial);
            stmt.setString(2, nomeFantasia);
            stmt.setString(3, cnpj);
            stmt.setInt(4, id);
            return stmt.executeUpdate() > 0;
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
