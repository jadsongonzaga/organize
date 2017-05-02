package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Estado;
import jadsongonzaga.organize.model.EstadoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author jadson
 */
public class EstadoController {

    private final EstadoDAO dao;

    public EstadoController() {
        this.dao = new EstadoDAO();
    }

    public Estado obter(int id) {
        Estado estado = null;
        try {
            estado = dao.obter(id);
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }
        return estado;
    }

    public DefaultComboBoxModel obterModelCombo() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        List<Estado> lEstado = new ArrayList<>();
        try {
            lEstado = dao.obter();
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }

        for (Estado e : lEstado) {
            combo.addElement(e);
        }

        return combo;
    }

}
