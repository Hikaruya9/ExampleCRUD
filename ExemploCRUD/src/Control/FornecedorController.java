/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Fornecedor;
import Model.FornecedorDAO;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author macig
 */
public class FornecedorController {
    public FornecedorDAO forDAO;

    public FornecedorController(FornecedorDAO forDAO) {
        this.forDAO = forDAO;
    }
    
    public void add(String razaoSocial, String nomeFantasia, String cnpj) {
        forDAO.add(razaoSocial, nomeFantasia, cnpj);
    }
    
    public ArrayList<Fornecedor> getAll() {
        return forDAO.getAll();
    }
    
    public Optional<Fornecedor> getById(int id) {
        return forDAO.getById(id);
    }
    
    public ArrayList<Fornecedor> getByRazaoSocial(String razaoSocial) {
        return forDAO.getByRazaoSocial(razaoSocial);
    }
    
    public ArrayList<Fornecedor> getByCnpj(String cnpj) {
        return forDAO.getByCnpj(cnpj);
    }
    
    public boolean update(int id, String razaoSocial, String nomeFantasia, String cnpj) {
        return forDAO.update(id, razaoSocial, nomeFantasia, cnpj);
    }
  
    public boolean delete(int id) {
        return forDAO.delete(id);
    }
}