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
public class UsuarioDAO_old {
    
    private static ArrayList<Usuario> usuarios = new ArrayList();
    private static int ultimoId = 1;
    
    public void adicionar(String nome, String username, String password) {
        Usuario u = new Usuario(ultimoId++, nome, username, password);
        usuarios.add(u);
    }
    
    public ArrayList<Usuario> getAll() {
        return usuarios;
    }
    
    public Optional<Usuario> getById(int id) {
        return usuarios.stream().filter(u -> u.getId() == id).findFirst();
    }
    
    public ArrayList<Usuario> getByName(String name) {
        ArrayList<Usuario> resposta = new ArrayList();
        for(Usuario u : usuarios) {
            if(u.getName().equalsIgnoreCase(name)) {
                resposta.add(u);
            }
        }
        return resposta;
    }
    
    public boolean delete(int id) {
        return usuarios.removeIf(u -> u.getId()==id);
    }
    
    public boolean update(int id, String nome, String username, String password) {
        Optional<Usuario> item = getById(id);
        if (item.isPresent()) {
            Usuario newUser = item.get();
            newUser.setName(nome);
            newUser.setUsername(username);
            newUser.setPassword(password);
            return true;
        }
        return false;
    }
}