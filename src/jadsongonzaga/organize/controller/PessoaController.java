package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Auditoria;
import jadsongonzaga.organize.model.Pessoa;
import jadsongonzaga.organize.model.PessoaDAO;
import java.sql.SQLException;

/**
 *
 * @author jadson
 */
public class PessoaController {

    private final PessoaDAO dao;
    private final AuditoriaController auditoria;

    public PessoaController() {
        dao = new PessoaDAO();
        auditoria = new AuditoriaController();
    }

    public void salvar(Pessoa pessoa, boolean inserir) {

        try {

            if (inserir) {
                dao.inserir(pessoa);
                auditoria.salvarInserir(pessoa.getId(), Auditoria.Rotina.PESSOA);
            } else {
                dao.alterar(pessoa);
                auditoria.salvarAlterar(pessoa.getId(), Auditoria.Rotina.PESSOA);
            }

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, pessoa);
        }

    }

    public void excluir(Pessoa pessoa) {
        try {

            dao.excluir(pessoa);
            auditoria.salvarDeletar(pessoa.getId(), Auditoria.Rotina.PESSOA);

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, pessoa);
        }
    }

    public Pessoa obter(int id) {

        Pessoa pessoa = null;
        try {
            pessoa = dao.obter(id);
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }
        return pessoa;
    }

}
