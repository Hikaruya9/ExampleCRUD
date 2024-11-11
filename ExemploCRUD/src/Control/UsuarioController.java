/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Usuario;
import Model.UsuarioDAO;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author macig
 */
public class UsuarioController {
    private UsuarioDAO userDAO;
    
    public UsuarioController(UsuarioDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    public void add(String nome, String username, String password) {
        userDAO.add(nome, username, password);
    }
    
    public ArrayList<Usuario> getAll() {
        return userDAO.getAll();
    }
    
    public Optional<Usuario> getById(int id) {
        return userDAO.getById(id);
    }
    
    public ArrayList<Usuario> getByName(String name) {
        return userDAO.getByName(name);
    }
    
    public boolean delete(int id) {
        return userDAO.delete(id);
    }
    
    public boolean update(int id, String nome, String username, String password) {
        return userDAO.update(id, nome, username, password);
    }
}