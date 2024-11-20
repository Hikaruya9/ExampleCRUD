/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aluno
 */
public class TableModel extends AbstractTableModel {
    private static final String[] columns = {"ID","CPF/CNPJ", "Name", "E-mail", "Phone Number", "Adress"};
    private ArrayList<Client> clients;
    
    public TableModel(ArrayList<Client> clients) {
        super();
        this.clients = clients;
    }

    @Override
    public int getRowCount() {
        return clients.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Client client = clients.get(rowIndex);
        switch(columnIndex) {
            case 0 -> {return client.getId();}
            case 1 -> {return client.getCpfCnpj();}
            case 2 -> {return client.getName();}
            case 3 -> {return client.getEmail();}
            case 4 -> {return client.getPhoneNumber();}
            case 5 -> {return client.getAdress();}
            default -> {return null;}
        }
    }

  public String getColumnName(int column) {
      return columns[column];
    }
}