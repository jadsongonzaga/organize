
package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Auditoria;
import jadsongonzaga.organize.model.Tratamento;
import jadsongonzaga.organize.model.TratamentoDAO;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author jadson
 */
public class TratamentoController {
     
    private final TratamentoDAO dao;
    private final AuditoriaController auditoria;

    public TratamentoController() {
        dao = new TratamentoDAO();
        auditoria = new AuditoriaController();
    }

    public void salvar(Tratamento tratamento, boolean inserir) {

        try {

            if (inserir) {
                dao.inserir(tratamento);
                auditoria.salvarInserir(tratamento.getId(), Auditoria.Rotina.TRATAMENTO);
            } else {
                dao.alterar(tratamento);
                auditoria.salvarAlterar(tratamento.getId(), Auditoria.Rotina.TRATAMENTO);
            }

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, tratamento);
        }

    }

    public void excluir(Tratamento tratamento) {
        try {

            dao.excluir(tratamento);
            auditoria.salvarDeletar(tratamento.getId(), Auditoria.Rotina.TRATAMENTO);

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, tratamento);
        }
    }

    public Tratamento obter(int id) {

        Tratamento tratamento = null;
        try {
            tratamento = dao.obter(id);
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }
        return tratamento;
    }
    
    public DefaultComboBoxModel obterModelComboTipoFim() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        combo.addElement(null);
      
        for (Tratamento.TipoFim tFim : Tratamento.TipoFim.values()) {
            combo.addElement(tFim);
        }

        return combo;
    }
}
