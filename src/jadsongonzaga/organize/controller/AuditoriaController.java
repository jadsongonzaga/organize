package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.Organize;
import jadsongonzaga.organize.model.Auditoria;
import jadsongonzaga.organize.model.AuditoriaDAO;

import java.sql.SQLException;

/**
 *
 * @author jadson
 */
public class AuditoriaController {

    private final AuditoriaDAO dao;

    public AuditoriaController() {
        dao = new AuditoriaDAO();
    }

    public void salvarInserir(int idRegistro, Auditoria.Rotina rotina) {
        salvar(idRegistro, rotina, Auditoria.TipoOperacao.INSERT);
    }

    public void salvarAlterar(int idRegistro, Auditoria.Rotina rotina) {
        salvar(idRegistro, rotina, Auditoria.TipoOperacao.UPDATE);
    }

    public void salvarDeletar(int idRegistro, Auditoria.Rotina rotina) {
        salvar(idRegistro, rotina, Auditoria.TipoOperacao.DELETE);
    }

    private void salvar(int idRegistro, Auditoria.Rotina rotina, Auditoria.TipoOperacao tipoOperacao){
        Auditoria auditoria = new Auditoria();
        auditoria.setTipoOperacao(tipoOperacao);
        auditoria.setUsuario(Organize.USUARIO);
        auditoria.setIdentificacaoRegistro(idRegistro);
        auditoria.setRotina(rotina);

        System.out.println("INSERIR AUDITORIA");
        /*try {
            
          dao.inserir(auditoria);
        } catch (SQLException ex) {
            ExceptionController.tratar(ex, auditoria);
        }*/
    }

}
