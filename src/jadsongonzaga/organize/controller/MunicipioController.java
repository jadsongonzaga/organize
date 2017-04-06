/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Estado;
import jadsongonzaga.organize.model.Municipio;
import jadsongonzaga.organize.model.MunicipioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author jadson
 */
public class MunicipioController {
    
    private final MunicipioDAO dao;

    public MunicipioController() {
        dao = new MunicipioDAO();
    }
    
    public Municipio obter(int id){
        Municipio municipio = null;
        
        try {
            municipio = dao.obter(id);
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }
        
        return municipio;
    }
    
    
    public DefaultComboBoxModel obterModelCombo(Estado estado){
        DefaultComboBoxModel combobox = new DefaultComboBoxModel();
        List<Municipio> lMunicipios = new ArrayList<>();
        
        try {
            lMunicipios = dao.obter(estado);
        } catch (SQLException ex) {
            Logger.getLogger(MunicipioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Municipio m:lMunicipios){
            combobox.addElement(m);
        }
        
        return combobox;
    }
    
}
