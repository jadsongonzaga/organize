
package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Auditoria;
import jadsongonzaga.organize.model.Doacao;
import jadsongonzaga.organize.model.DoacaoDAO;
import java.sql.SQLException;

/**
 *
 * @author jadson
 */
public class DoacaoController {
    
    private final DoacaoDAO dao;
    private final AuditoriaController auditoria;

    public DoacaoController() {
        dao = new DoacaoDAO();
        auditoria = new AuditoriaController();
    }

    public void salvar(Doacao doacao, boolean inserir) {

        try {

            if (inserir) {
                dao.inserir(doacao);
                auditoria.salvarInserir(doacao.getId(), Auditoria.Rotina.DOACAO);
            } else {
                dao.alterar(doacao);
                auditoria.salvarAlterar(doacao.getId(), Auditoria.Rotina.DOACAO);
            }

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, doacao);
        }

    }

    public void excluir(Doacao doacao) {
        try {

            dao.excluir(doacao);
            auditoria.salvarDeletar(doacao.getId(), Auditoria.Rotina.DOACAO);

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, doacao);
        }
    }

    public Doacao obter(int id) {

        Doacao doacao = null;
        try {
            doacao = dao.obter(id);
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }
        return doacao;
    }
    
}
