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
public class ProdutoDAO_old {
    public static ArrayList<Produto> produtos = new ArrayList();
    public static int ultimoid = 1;
    
    public void add(String nome, double valor) {
        Produto p = new Produto(ultimoid++, nome, valor);
        produtos.add(p);
    }
    
    public ArrayList<Produto> getAll() {
        return produtos;
    }
    
    public Optional<Produto> getById(int id) {
        return produtos.stream().filter(p -> p.getId() == id).findFirst();
    }
    
    public ArrayList<Produto> getByName(String nome) {
        ArrayList<Produto> resposta = new ArrayList();
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                resposta.add(p);
            }
        }
        return resposta;
    }

    public boolean delete(int id) {
        return produtos.removeIf(p -> p.getId() == id);
    }
    
    public boolean update(int id, String nome, double preco) {
        Optional<Produto> item = getById(id);
        if (item.isPresent()) {
            Produto prod = item.get();
            prod.setNome(nome);
            prod.setValor(preco);
            return true;
        }
        return false;
    }
    
    public ArrayList<Produto> getByMinPrice(double min) {
        ArrayList<Produto> resposta = new ArrayList();
        for (Produto p : produtos) {
            if (p.getValor() >= min) {
                resposta.add(p);
            }
        }
        return resposta;
    }
    
    public ArrayList<Produto> getByMaxPrice(double max) {
        ArrayList<Produto> resposta = new ArrayList();
        for (Produto p : produtos) {
            if (p.getValor() <= max) {
                resposta.add(p);
            }
        }
        return resposta;
    }
    
    public ArrayList<Produto> getPriceBetween(double min, double max) {
        ArrayList<Produto> resposta = new ArrayList();
        for (Produto p : produtos) {
            if (p.getValor() >= min && p.getValor() <= max) {
                resposta.add(p);
            }
        }
        return resposta;
    }
}