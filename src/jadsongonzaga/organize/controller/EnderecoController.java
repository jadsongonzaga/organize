package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Auditoria;
import jadsongonzaga.organize.model.Endereco;
import jadsongonzaga.organize.model.EnderecoDAO;
import java.sql.SQLException;

/**
 *
 * @author jadson
 */
public class EnderecoController {

    private final EnderecoDAO dao;
    private final AuditoriaController auditoria;

    public EnderecoController() {
        dao = new EnderecoDAO();
        auditoria = new AuditoriaController();
    }

    public void salvar(Endereco endereco, boolean inserir) {

        try {

            if (inserir) {
                dao.inserir(endereco);
                auditoria.salvarInserir(endereco.getId(), Auditoria.Rotina.ENDERECO);
            } else {
                dao.alterar(endereco);
                auditoria.salvarAlterar(endereco.getId(), Auditoria.Rotina.ENDERECO);
            }

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, endereco);
        }

    }
    
     public void excluir(Endereco endereco) {
        try {

            dao.excluir(endereco);
            auditoria.salvarDeletar(endereco.getId(), Auditoria.Rotina.PESSOA);

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, endereco);
        }
    }

    public Endereco obter(int id) {

        Endereco endereco = null;
        try {
            endereco = dao.obter(id);
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }
        return endereco;
    }

}
