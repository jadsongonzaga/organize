
package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Auditoria;
import jadsongonzaga.organize.model.UtilizacaoDoacao;
import jadsongonzaga.organize.model.UtilizacaoDoacaoDAO;
import java.sql.SQLException;

/**
 *
 * @author jadson
 */
public class UtilizacaoDoacaoController {
    
    private final UtilizacaoDoacaoDAO dao;
    private final AuditoriaController auditoria;

    public UtilizacaoDoacaoController() {
        dao = new UtilizacaoDoacaoDAO();
        auditoria = new AuditoriaController();
    }

    public void salvar(UtilizacaoDoacao doacao, boolean inserir) {

        try {

            if (inserir) {
                dao.inserir(doacao);
                auditoria.salvarInserir(doacao.getId(), Auditoria.Rotina.UTILIZACAO_DOACAO);
            } else {
                dao.alterar(doacao);
                auditoria.salvarAlterar(doacao.getId(), Auditoria.Rotina.UTILIZACAO_DOACAO);
            }

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, doacao);
        }

    }

    public void excluir(UtilizacaoDoacao doacao) {
        try {

            dao.excluir(doacao);
            auditoria.salvarDeletar(doacao.getId(), Auditoria.Rotina.UTILIZACAO_DOACAO);

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, doacao);
        }
    }

    public UtilizacaoDoacao obter(int id) {

        UtilizacaoDoacao doacao = null;
        try {
            doacao = dao.obter(id);
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }
        return doacao;
    }
}
