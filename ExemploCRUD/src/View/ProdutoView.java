/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Control.ProdutoController;
import Model.Produto;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

/**
 *
 * @author macig
 */
public class ProdutoView {
    private ProdutoController prodController;

    public ProdutoView(ProdutoController prodController) {
        this.prodController = prodController;
    }
    
    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Preco: ");
        double preco = scanner.nextDouble();
        prodController.add(nome, preco);
        System.out.println("Produto adicionado com sucesso!");
    }
    
    public void getAll() {
        for (Produto p : prodController.getAll()) {
            System.out.print("ID: "+p.getId()+"\t");
            System.out.print("Nome: "+p.getNome()+"\t");
            System.out.printf("Preco: R$%.2f\n",p.getValor());
        }
    }
    
    public void getById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID: ");
        int id = scanner.nextInt();
        Optional<Produto> p = prodController.getById(id);
        p.ifPresentOrElse(
                pr -> System.out.printf("ID: "+pr.getId()+"\tNome: "+pr.getNome()+"\tPreco: %.2f\n",pr.getValor()),
                () -> System.out.println("Produto nao encontrado!")
        );
    }
    
    public void getByNome() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        ArrayList<Produto> resposta = prodController.getByName(nome);
        for (Produto p : resposta) {
            System.out.print("ID: "+p.getId()+"\t");
            System.out.print("Nome: "+p.getNome()+"\t");
            System.out.printf("Preco: R$%.2f\n",p.getValor());
        }
    }
    
    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID: ");
        int id = scanner.nextInt();
        
        if (prodController.delete(id)) {
            System.out.println("Produto excluido com sucesso!");
        } else {
            System.out.println("Produto nao encontrado!");
        }
    }
    
    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.skip("\\R");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Preco: ");
        double preco = scanner.nextDouble();
        
        if (prodController.update(id, nome, preco)) {
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto nao encontrado!");
        }
    }
    
    public void getByMinPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Preco min: ");
        double min = scanner.nextDouble();
        
        ArrayList<Produto> prod = prodController.getByMinPrice(min);
        for (Produto p : prod) {
            System.out.print("ID: "+p.getId()+"\t");
            System.out.print("Nome: "+p.getNome()+"\t");
            System.out.printf("Preco: R$%.2f\n",p.getValor());
        }
    }
    
    public void getByMaxPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Preco max: ");
        double max = scanner.nextDouble();
        
        ArrayList<Produto> prod = prodController.getByMaxPrice(max);
        for (Produto p : prod) {
            System.out.print("ID: "+p.getId()+"\t");
            System.out.print("Nome: "+p.getNome()+"\t");
            System.out.printf("Preco: R$%.2f\n",p.getValor());
        }
    }
    
    public void getByPriceBetween() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Preco min: ");
        double min = scanner.nextDouble();
        System.out.print("Preco max: ");
        double max = scanner.nextDouble();
        
        ArrayList<Produto> prod = prodController.getByPriceBetween(min, max);
        for (Produto p : prod) {
            System.out.print("ID: "+p.getId()+"\t");
            System.out.print("Nome: "+p.getNome()+"\t");
            System.out.printf("Preco: R$%.2f\n",p.getValor());
        }
    }
    
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\n##GESTAO DE PRODUTOS##\n");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Alterar produto");
            System.out.println("3 - Excluir produto");
            System.out.println("4 - Listar todos os produtos");
            System.out.println("5 - Listar por codigo");
            System.out.println("6 - Listar por nome");
            System.out.println("7 - Listar produtos de preco minimo");
            System.out.println("8 - Listar produtos de preco maximo");
            System.out.println("9 - Listar produtos entre");
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
                case 6 -> getByNome();
                case 7 -> getByMinPrice();
                case 8 -> getByMaxPrice();
                case 9 -> getByPriceBetween();
                default -> System.out.println("Opcao invalida!");
            }
        }
    }
}