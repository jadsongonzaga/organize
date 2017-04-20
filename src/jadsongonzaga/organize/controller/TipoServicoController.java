

package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Auditoria;
import jadsongonzaga.organize.model.TipoServico;
import jadsongonzaga.organize.model.TipoServicoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author jadson
 */
public class TipoServicoController {
    
    private final TipoServicoDAO dao;
    private final AuditoriaController auditoria;

    public TipoServicoController() {
        dao = new TipoServicoDAO();
        auditoria = new AuditoriaController();
    }

    public void salvar(TipoServico tipoServico, boolean inserir) {

        try {

            if (inserir) {
                dao.inserir(tipoServico);
                auditoria.salvarInserir(tipoServico.getId(), Auditoria.Rotina.TIPO_SERVICO);
            } else {
                dao.alterar(tipoServico);
                auditoria.salvarAlterar(tipoServico.getId(), Auditoria.Rotina.TIPO_SERVICO);
            }

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, tipoServico);
        }

    }

    public void excluir(TipoServico tipoServico) {
        try {

            dao.excluir(tipoServico);
            auditoria.salvarDeletar(tipoServico.getId(), Auditoria.Rotina.TIPO_SERVICO);

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, tipoServico);
        }
    }

    public TipoServico obter(int id) {

        TipoServico tipoServico = null;
        try {
            tipoServico = dao.obter(id);
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }
        return tipoServico;
    }
    
    public DefaultComboBoxModel obterModelCombo() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        List<TipoServico> lTipoServico = new ArrayList<>();
        try {
            lTipoServico = dao.obter();
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }

        for (TipoServico tc : lTipoServico) {
            combo.addElement(tc);
        }

        return combo;
    }
}
