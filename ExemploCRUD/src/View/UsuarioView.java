/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Control.UsuarioController;
import Model.Usuario;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

/**
 *
 * @author macig
 */
public class UsuarioView {

    private UsuarioController usuarioController;

    public UsuarioView(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Usuario: ");
        String username = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();
        usuarioController.add(nome, username, password);
        System.out.println("Usuario salvo!");
    }

    public void getAll() {
        for (Usuario u : usuarioController.getAll()) {
            System.out.print("Id: ");
            System.out.print(u.getId() + "\t");
            System.out.print("Nome: ");
            System.out.print(u.getName() + "\t");
            System.out.print("Usuario: ");
            System.out.print(u.getUsername() + "\t");
            System.out.print("Senha: ");
            System.out.println(u.getPassword());
        }
    }

    public void getById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID a ser buscado: ");
        int id = scanner.nextInt();
        Optional<Usuario> u = usuarioController.getById(id);
        u.ifPresentOrElse(
                us -> System.out.println("ID: " + us.getId() + "\tNome: " + us.getName() + "\tUsuario: " + us.getUsername() + "\tSenha: " + us.getPassword()),
                () -> System.out.println("Nao encontrado!")
        );
    }

    public void getByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome a ser buscado: ");
        String name = scanner.nextLine();
        ArrayList<Usuario> resposta = usuarioController.getByName(name);
        if (resposta.isEmpty()) {
            System.out.println("Nao foram encontrados usuarios com esse nome!");
        } else {
            for (Usuario u : resposta) {
                System.out.print("Id: ");
                System.out.print(u.getId() + "\t");
                System.out.print("Nome: ");
                System.out.print(u.getName() + "\t");
                System.out.print("Usuario: ");
                System.out.print(u.getUsername() + "\t");
                System.out.print("Senha: ");
                System.out.println(u.getPassword());
            }
        }
    }
    
    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID a ser removido: ");
        int id = scanner.nextInt();
        
        if(usuarioController.delete(id)) {
            System.out.println("Usuario excluido com sucesso!");
        } else {
            System.out.println("Usuario nao encontrado");
        }
    }
    
    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.skip("\\R");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Usuario: ");
        String username = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();
        if(usuarioController.update(id, nome, username, password)) {
            System.out.println("Usuario atualizado!");
        } else {
            System.out.println("Usuario nao encontrado!");
        }
    }
    
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("\n##GESTAO DE USUARIOS##\n");
            System.out.println("1 - Adicionar usuario");
            System.out.println("2 - Listar todos os usuarios");
            System.out.println("3 - Localizar usuario por codigo");
            System.out.println("4 - Localizar usuario por nome");
            System.out.println("5 - Alterar dados de um usuario");
            System.out.println("6 - Excluir usuario");
            System.out.println("7 - Sair\n");
            System.out.print("Opcao: ");
            int opcao = scanner.nextInt();
            
            switch(opcao) {
                case 1 -> add();
                case 2 -> getAll();
                case 3 -> getById();
                case 4 -> getByName();
                case 5 -> update();
                case 6 -> delete();
                case 7 -> System.exit(0);
                default -> System.out.println("Opcao invalida!");
            }
        }
    }
}