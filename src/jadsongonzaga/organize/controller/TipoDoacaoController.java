

package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Auditoria;
import jadsongonzaga.organize.model.TipoDoacao;
import jadsongonzaga.organize.model.TipoDoacaoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author jadson
 */
public class TipoDoacaoController {
    
    private final TipoDoacaoDAO dao;
    private final AuditoriaController auditoria;

    public TipoDoacaoController() {
        dao = new TipoDoacaoDAO();
        auditoria = new AuditoriaController();
    }

    public void salvar(TipoDoacao tipoDoacao, boolean inserir) {

        try {

            if (inserir) {
                dao.inserir(tipoDoacao);
                auditoria.salvarInserir(tipoDoacao.getId(), Auditoria.Rotina.TIPO_DOACAO);
            } else {
                dao.alterar(tipoDoacao);
                auditoria.salvarAlterar(tipoDoacao.getId(), Auditoria.Rotina.TIPO_DOACAO);
            }

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, tipoDoacao);
        }

    }

    public void excluir(TipoDoacao tipoDoacao) {
        try {

            dao.excluir(tipoDoacao);
            auditoria.salvarDeletar(tipoDoacao.getId(), Auditoria.Rotina.TIPO_DOACAO);

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, tipoDoacao);
        }
    }

    public TipoDoacao obter(int id) {

        TipoDoacao tipoDoacao = null;
        try {
            tipoDoacao = dao.obter(id);
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }
        return tipoDoacao;
    }
    
    public DefaultComboBoxModel obterModelCombo() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        List<TipoDoacao> lTipoDoacao = new ArrayList<>();
        try {
            lTipoDoacao = dao.obter();
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }

        for (TipoDoacao tc : lTipoDoacao) {
            combo.addElement(tc);
        }

        return combo;
    }
}
