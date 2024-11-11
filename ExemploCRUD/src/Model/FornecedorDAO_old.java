/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author macig
 */
public class FornecedorDAO_old {
    public static ArrayList<Fornecedor> fornecedores = new ArrayList();
    public static int ultimoid = 1;

    public void add(String razaoSocial, String nomeFantasia, String cnpj) {
        Fornecedor f = new Fornecedor(ultimoid++, razaoSocial, nomeFantasia, cnpj);
        fornecedores.add(f);
    }
    
    public ArrayList<Fornecedor> getAll() {
        ArrayList<Fornecedor> resposta = new ArrayList();
        for (Fornecedor f : fornecedores) {
            resposta.add(f);
        }
        return resposta;
    }
    
    public Optional<Fornecedor> getById(int id) {
        return fornecedores.stream().filter(f -> f.getId() == id).findFirst();
    }
    
    public ArrayList<Fornecedor> getByRazaoSocial(String razaoSocial) {
        ArrayList<Fornecedor> resposta = new ArrayList();
        for (Fornecedor f : fornecedores) {
            if(f.getRazaoSocial().equalsIgnoreCase(razaoSocial)) {
                resposta.add(f);
            }
        }
        return resposta;
    }
    
    public ArrayList<Fornecedor> getByCnpj(String cnpj) {
        ArrayList<Fornecedor> resposta = new ArrayList();
        for (Fornecedor f : fornecedores) {
            if (f.getCnpj().equalsIgnoreCase(cnpj)) {
                resposta.add(f);
            }
        }
        return resposta;
    }
    
    public boolean update(int id, String razaoSocial, String nomeFantasia, String cnpj) {
        Optional<Fornecedor> item = getById(id);
        if (item.isPresent()) {
            Fornecedor f = item.get();
            f.setRazaoSocial(razaoSocial);
            f.setNomeFantasia(nomeFantasia);
            f.setCnpj(cnpj);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        return fornecedores.removeIf(f -> f.getId() == id);
    }
}