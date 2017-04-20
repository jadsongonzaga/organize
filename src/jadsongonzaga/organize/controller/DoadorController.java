

package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Auditoria;
import jadsongonzaga.organize.model.Doador;
import jadsongonzaga.organize.model.DoadorDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author jadson
 */
public class DoadorController {
    
    private final DoadorDAO dao;
    private final AuditoriaController auditoria;

    public DoadorController() {
        dao = new DoadorDAO();
        auditoria = new AuditoriaController();
    }

    public void salvar(Doador doador, boolean inserir) {

        try {

            if (inserir) {
                dao.inserir(doador);
                auditoria.salvarInserir(doador.getId(), Auditoria.Rotina.DOADOR);
            } else {
                dao.alterar(doador);
                auditoria.salvarAlterar(doador.getId(), Auditoria.Rotina.DOADOR);
            }

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, doador);
        }

    }

    public void excluir(Doador doador) {
        try {

            dao.excluir(doador);
            auditoria.salvarDeletar(doador.getId(), Auditoria.Rotina.DOADOR);

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, doador);
        }
    }

    public Doador obter(int id) {

        Doador doador = null;
        try {
            doador = dao.obter(id);
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }
        return doador;
    }
    
    public DefaultComboBoxModel obterModelCombo() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        List<Doador> lDoador = new ArrayList<>();
        try {
            lDoador = dao.obter();
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }

        for (Doador tc : lDoador) {
            combo.addElement(tc);
        }

        return combo;
    }
}
