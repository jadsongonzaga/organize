package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Auditoria;
import jadsongonzaga.organize.model.Acompanhante;
import jadsongonzaga.organize.model.AcompanhanteDAO;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author jadson
 */
public class AcompanhanteController {

    private final AcompanhanteDAO dao;
    private final AuditoriaController auditoria;

    public AcompanhanteController() {
        dao = new AcompanhanteDAO();
        auditoria = new AuditoriaController();
    }

    public void salvar(Acompanhante acompanhante, boolean inserir) {

        try {

            if (inserir) {
                dao.inserir(acompanhante);
                auditoria.salvarInserir(acompanhante.getPessoa().getId(), Auditoria.Rotina.ACOMPANHANTE);
            } else {
                dao.alterar(acompanhante);
                auditoria.salvarAlterar(acompanhante.getPessoa().getId(), Auditoria.Rotina.ACOMPANHANTE);
            }

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, acompanhante);
        }
    }

    public Acompanhante obter(int id) {

        Acompanhante acompanhante = null;
        try {
            acompanhante = dao.obter(id);
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }
        return acompanhante;
    }
    
    public void excluir(Acompanhante acompanhante){
        try {
            dao.excluir(acompanhante);
            auditoria.salvarDeletar(acompanhante.getPessoa().getId(), Auditoria.Rotina.ACOMPANHANTE );
        } catch (SQLException ex) {
            ExceptionController.tratar(ex, acompanhante);
        }
    }

    public DefaultComboBoxModel obterModelComboParentesco() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
      
        for (Acompanhante.GrauParentesco gp : Acompanhante.GrauParentesco.values()) {
            combo.addElement(gp);
        }

        return combo;
    }

}
