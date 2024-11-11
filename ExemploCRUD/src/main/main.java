/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Control.FornecedorController;
import Control.ProdutoController;
import Control.UsuarioController;
import Model.FornecedorDAO;
import Model.ProdutoDAO;
import Model.UsuarioDAO;
import View.FornecedorView;
import View.ProdutoView;
import View.UsuarioView;

/**
 *
 * @author Aluno
 */
public class main {

    public static void main(String[] args) {
        UsuarioDAO userDAO = new UsuarioDAO();
        UsuarioController userController = new UsuarioController(userDAO);
        UsuarioView userView = new UsuarioView(userController);
        FornecedorDAO forDAO = new FornecedorDAO();
        FornecedorController forController = new FornecedorController(forDAO);
        FornecedorView forView = new FornecedorView(forController);
        ProdutoDAO prodDAO = new ProdutoDAO();
        ProdutoController prodController = new ProdutoController(prodDAO);
        ProdutoView prodView = new ProdutoView(prodController);

//        userView.showMenu();
//        forView.showMenu();
//        prodView.showMenu();

        /*
    Do mesmo modo que criamos a gestão de usuários, agora faça a gestão de produtos e a gestão de fornecedores

    O cadastro de fornecedores deve possuir:
        ID
        Razão Social
        Nome Fantasia
        CNPJ

        Ações:
        - Cadastrar
        - Alterar
        - Excluir
        - Listar todos
        - Listar por ID
        - Consultar por Razão social
        - Consultar por CNPJ
        
        
    O cadastro de produtos deve possuir:
        ID
        Nome
        Valor
        
        Ações:
        - Cadastrar
        - Alterar
        - Excluir
        - Listar todos
        - Listar por ID
        - Consultar por nome
        - Consultar por valor mínimo
        - Consultar por valor máximo
        - Consultar por valor entre
         */
    }
}