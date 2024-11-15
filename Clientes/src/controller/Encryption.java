/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Aluno
 */
public class Encryption {
    public static final String SHA256 = "SHA-256";
    public static final String MD5 = "MD5";
    
    protected String information;
    protected String padrao;
    
    public Encryption(String information, String padrao) {
        this.information = information;
        this.padrao = padrao;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getPadrao() {
        return padrao;
    }

    public void setPadrao(String padrao) {
        this.padrao = padrao;
    }

    public String encrypt(){
        String information = getInformation(); //Busca a informação a ser criptografada
        
        MessageDigest messageDigest; // Cria o obj que gera o Hash
        
        StringBuilder hexString = null; // Declara variávei hexString que armazena um obj do tipo StringBuilder
        
        try{
            messageDigest = MessageDigest.getInstance(getPadrao()); // getPadrao() define qual algoritmo que vai ser usado (MD5,SHA256)
            
            byte[] hash = messageDigest.digest(information.getBytes(StandardCharsets.UTF_8)); //A informação é convertida em bytes e passada para o método digest(), que calcula o hash e retorna um Array de bytes.
            
            /*
            Pegando o array de bytes do hash e convertendo para uma representação hexadecimal. 
            */
            hexString = new StringBuilder(2*hash.length);
            
            for(int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1){
                    hexString.append('0');
                }
                hexString.append(hex);
            }
        }catch(NoSuchAlgorithmException e){ //Lida com a exceção NoSuchAlgorithmException, que ocorre caso o algoritmo especificado não seja encontrado.
            e.printStackTrace();
        }
        return hexString.toString().toUpperCase();
    }
}