/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controller.Conexao;
import java.sql.Connection;
/**
 *
 * @author Aluno
 */
public class DB {
    private static Connection connection = null;
    
    public static void main(String[] args) {
        try{
            connection = Conexao.getConnection();
            System.out.println("Base criada com sucesso!");
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
