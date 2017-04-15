

package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Auditoria;
import jadsongonzaga.organize.model.Clinica;
import jadsongonzaga.organize.model.ClinicaDAO;
import java.sql.SQLException;

/**
 *
 * @author jadson
 */
public class ClinicaController {
    
    private final ClinicaDAO dao;
    private final AuditoriaController auditoria;

    public ClinicaController() {
        dao = new ClinicaDAO();
        auditoria = new AuditoriaController();
    }

    public void salvar(Clinica clinica, boolean inserir) {

        try {

            if (inserir) {
                dao.inserir(clinica);
                auditoria.salvarInserir(clinica.getId(), Auditoria.Rotina.CLINICA);
            } else {
                dao.alterar(clinica);
                auditoria.salvarAlterar(clinica.getId(), Auditoria.Rotina.CLINICA);
            }

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, clinica);
        }

    }

    public void excluir(Clinica clinica) {
        try {

            dao.excluir(clinica);
            auditoria.salvarDeletar(clinica.getId(), Auditoria.Rotina.CLINICA);

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, clinica);
        }
    }

    public Clinica obter(int id) {

        Clinica clinica = null;
        try {
            clinica = dao.obter(id);
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }
        return clinica;
    }
}
