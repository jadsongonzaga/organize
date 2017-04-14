/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadsongonzaga.organize.view;

import jadsongonzaga.organize.controller.Utils;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jadson
 */
public class BuscaTableModel extends AbstractTableModel {

    
    Set<String> colunas;

    List<Map<String, Object>> dados;
    
    public BuscaTableModel(List<Map<String, Object>> dados) {
        if(dados.size() > 0){
            colunas =  dados.get(0).keySet();
            this.dados = dados;
        }
    }
    
    public BuscaTableModel(){
        colunas = new LinkedHashSet<>();
        dados = new LinkedList<>();
    }

    @Override
    public String getColumnName(int column) {
        return Utils.capitalize(colunas.toArray()[column].toString());
    }

    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        return dados.get(rowIndex).get(colunas.toArray()[columnIndex]);
         
    }

}
