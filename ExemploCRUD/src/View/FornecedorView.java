/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Control.FornecedorController;
import Model.Fornecedor;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

/**
 *
 * @author macig
 */
public class FornecedorView {
    public FornecedorController forController;

    public FornecedorView(FornecedorController forController) {
        this.forController = forController;
    }
    
    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Razao social: ");
        String razaoSocial = scanner.nextLine();
        System.out.print("Nome fantasia: ");
        String nomeFantasia = scanner.nextLine();
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        
        forController.add(razaoSocial, nomeFantasia, cnpj);
        System.out.println("Fornecedor adicionado com sucesso!");
    }
    
    public void getAll() {
        for (Fornecedor f : forController.getAll()) {
            System.out.print("ID: "+f.getId()+"\t");
            System.out.print("Razao social: "+f.getRazaoSocial()+"\t");
            System.out.print("Nome fantasia: "+f.getNomeFantasia()+"\t");
            System.out.println("CNPJ: "+f.getCnpj());
        }
    }
    
    public void getById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID: ");
        int id = scanner.nextInt();
        
        Optional<Fornecedor> f = forController.getById(id);
        f.ifPresentOrElse(
                fo -> System.out.println("ID: "+fo.getId()+"\tRazao social: "+fo.getRazaoSocial()+"\tNome fantasia: "+fo.getNomeFantasia()+"\tCNPJ: "+fo.getCnpj()),
                () -> System.out.println("Fornecedor nao encontrado!")
        );
    }
    
    public void getByRazaoSocial() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Razao social: ");
        String razaoSocial = scanner.nextLine();
        
        ArrayList<Fornecedor> resposta = forController.getByRazaoSocial(razaoSocial);
        for (Fornecedor f : resposta) {
            System.out.print("ID: "+f.getId()+"\t");
            System.out.print("Razao social: "+f.getRazaoSocial()+"\t");
            System.out.print("Nome fantasia: "+f.getNomeFantasia()+"\t");
            System.out.println("CNPJ: "+f.getCnpj());
        }
    }

    public void getByCnpj() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        
        ArrayList<Fornecedor> resposta = forController.getByCnpj(cnpj);
        for (Fornecedor f : resposta) {
            System.out.print("ID: "+f.getId()+"\t");
            System.out.print("Razao social: "+f.getRazaoSocial()+"\t");
            System.out.print("Nome fantasia: "+f.getNomeFantasia()+"\t");
            System.out.println("CNPJ: "+f.getCnpj());
        }
    }
    
    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.skip("\\R");
        System.out.print("Razao social: ");
        String razaoSocial = scanner.nextLine();
        System.out.print("Nome fantasia: ");
        String nomeFantasia = scanner.nextLine();
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        
        if (forController.update(id, razaoSocial, nomeFantasia, cnpj)) {
            System.out.println("Fornecedor atualizado com sucesso!");
        } else {
            System.out.println("Fornecedor nao encontrado!");
        }
    }
    
    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID: ");
        int id = scanner.nextInt();
        
        if (forController.delete(id)) {
            System.out.println("Fornecedor excluido com sucesso!");
        } else {
            System.out.println("Fornecedor nao encontrado!");
        }
    }
    
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\n##GESTAO DE FORNECEDORES##\n");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Alterar produto");
            System.out.println("3 - Excluir produto");
            System.out.println("4 - Listar todos os produtos");
            System.out.println("5 - Listar por codigo");
            System.out.println("6 - Listar por Razao social");
            System.out.println("7 - Listar por CNPJ");
            System.out.println("0 - Sair\n");
            
            System.out.print("Digite a opcao desejada: ");
            int opcao = scanner.nextInt();
            
            switch(opcao) {
                case 0 -> System.exit(0);
                case 1 -> add();
                case 2 -> update();
                case 3 -> delete();
                case 4 -> getAll();
                case 5 -> getById();
                case 6 -> getByRazaoSocial();
                case 7 -> getByCnpj();
                default -> System.out.println("Opcao invalida!");
            }
        }
    }
}