
package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Auditoria;
import jadsongonzaga.organize.model.Servico;
import jadsongonzaga.organize.model.ServicoDAO;
import jadsongonzaga.organize.model.ServicoItemDAO;
import jadsongonzaga.organize.model.Situacao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author jadson
 */
public class ServicoController {
    
    private final ServicoDAO dao;
    private final AuditoriaController auditoria;

    public ServicoController() {
        dao = new ServicoDAO();
        auditoria = new AuditoriaController();
    }

    public void salvar(Servico servico, boolean inserir) {

        try {

            if (inserir) {
                dao.inserir(servico);
                auditoria.salvarInserir(servico.getId(), Auditoria.Rotina.SERVICO);
            } else {
                dao.alterar(servico);
                auditoria.salvarAlterar(servico.getId(), Auditoria.Rotina.SERVICO);
            }

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, servico);
        }

    }

    public void excluir(Servico servico) {
        try {

            new ServicoItemDAO().excluir(servico);
            auditoria.salvarDeletar(servico.getId(), Auditoria.Rotina.SERVICO_ITEM);
            dao.excluir(servico);
            auditoria.salvarDeletar(servico.getId(), Auditoria.Rotina.SERVICO);


        } catch (SQLException ex) {
            ExceptionController.tratar(ex, servico);
        }
    }

    public Servico obter(int id) {

        Servico servico = null;
        try {
            servico = dao.obter(id);
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }
        return servico;
    }
    
    public DefaultComboBoxModel obterModelComboSituacao() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
      
        for (Situacao situacao : Situacao.values()) {
            combo.addElement(situacao);
        }

        return combo;
    }
    
    
    public DefaultComboBoxModel obterModelCombo() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        List<Servico> lServico = new ArrayList<>();
        try {
            lServico = dao.obter();
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }

        for (Servico tc : lServico) {
            combo.addElement(tc);
        }

        return combo;
    }
}