/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Produto;
import Model.ProdutoDAO;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author macig
 */
public class ProdutoController {
    private ProdutoDAO prodDAO;

    public ProdutoController(ProdutoDAO prodDAO) {
        this.prodDAO = prodDAO;
    }
    
    public void add(String nome, double valor) {
        prodDAO.add(nome, valor);
    }
    
    public ArrayList<Produto> getAll() {
        return prodDAO.getAll();
    }
    
    public Optional<Produto> getById(int id) {
        return prodDAO.getById(id);
    }
    
    public ArrayList<Produto> getByName(String nome) {
        return prodDAO.getByName(nome);
    }
    
    public boolean delete(int id) {
        return prodDAO.delete(id);
    }
    
    public boolean update(int id, String nome, double valor) {
        return prodDAO.update(id, nome, valor);
    }
    
    public ArrayList<Produto> getByMinPrice(double min) {
        return prodDAO.getByMinPrice(min);
    }
    
    public ArrayList<Produto> getByMaxPrice(double max) {
        return prodDAO.getByMaxPrice(max);
    }
    
    public ArrayList<Produto> getByPriceBetween(double min, double max) {
        return prodDAO.getByPriceBetween(min, max);
    }
}