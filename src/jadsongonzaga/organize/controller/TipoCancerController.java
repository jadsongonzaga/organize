

package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Auditoria;
import jadsongonzaga.organize.model.TipoCancer;
import jadsongonzaga.organize.model.TipoCancerDAO;
import java.sql.SQLException;

/**
 *
 * @author jadson
 */
public class TipoCancerController {
    
    private final TipoCancerDAO dao;
    private final AuditoriaController auditoria;

    public TipoCancerController() {
        dao = new TipoCancerDAO();
        auditoria = new AuditoriaController();
    }

    public void salvar(TipoCancer tipoCancer, boolean inserir) {

        try {

            if (inserir) {
                dao.inserir(tipoCancer);
                auditoria.salvarInserir(tipoCancer.getId(), Auditoria.Rotina.TIPO_CANCER);
            } else {
                dao.alterar(tipoCancer);
                auditoria.salvarAlterar(tipoCancer.getId(), Auditoria.Rotina.TIPO_CANCER);
            }

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, tipoCancer);
        }

    }

    public void excluir(TipoCancer tipoCancer) {
        try {

            dao.excluir(tipoCancer);
            auditoria.salvarDeletar(tipoCancer.getId(), Auditoria.Rotina.TIPO_CANCER);

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, tipoCancer);
        }
    }

    public TipoCancer obter(int id) {

        TipoCancer tipoCancer = null;
        try {
            tipoCancer = dao.obter(id);
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }
        return tipoCancer;
    }
}
