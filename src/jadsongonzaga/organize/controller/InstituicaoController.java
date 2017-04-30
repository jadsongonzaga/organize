

package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Auditoria;
import jadsongonzaga.organize.model.Instituicao;
import jadsongonzaga.organize.model.InstituicaoDAO;
import java.sql.SQLException;

/**
 *
 * @author jadson
 */
public class InstituicaoController {
    
    private final InstituicaoDAO dao;
    private final AuditoriaController auditoria;

    public InstituicaoController() {
        dao = new InstituicaoDAO();
        auditoria = new AuditoriaController();
    }

    public void salvar(Instituicao tipoDoacao, boolean inserir) {

        try {

            if (inserir) {
                dao.inserir(tipoDoacao);
                auditoria.salvarInserir(tipoDoacao.getId(), Auditoria.Rotina.INSTITUICAO);
            } else {
                dao.alterar(tipoDoacao);
                auditoria.salvarAlterar(tipoDoacao.getId(), Auditoria.Rotina.INSTITUICAO);
            }

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, tipoDoacao);
        }

    }

    public Instituicao obter() {

        Instituicao tipoDoacao = null;
        try {
            tipoDoacao = dao.obter();
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }
        return tipoDoacao;
    }

}
