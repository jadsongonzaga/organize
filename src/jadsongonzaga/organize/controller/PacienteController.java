

package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Paciente;
import jadsongonzaga.organize.model.PacienteDAO;
import jadsongonzaga.organize.model.Auditoria;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author jadson
 */
public class PacienteController {
    
    private final PacienteDAO dao;
    private final AuditoriaController auditoria;

    public PacienteController() {
        dao = new PacienteDAO();
        auditoria = new AuditoriaController();
    }

    public void salvar(Paciente paciente, boolean inserir) {

        try {

            if (inserir) {
                dao.inserir(paciente);
                auditoria.salvarInserir(paciente.getPessoa().getId(), Auditoria.Rotina.PACIENTE);
            } else {
                dao.alterar(paciente);
                auditoria.salvarAlterar(paciente.getPessoa().getId(), Auditoria.Rotina.PACIENTE);
            }

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, paciente);
        }
    }

    public Paciente obter(int id) {

        Paciente paciente = null;
        try {
            paciente = dao.obter(id);
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }
        return paciente;
    }
    
    public void excluir(Paciente paciente){
        try {
            dao.excluir(paciente);
            auditoria.salvarDeletar(paciente.getPessoa().getId(), Auditoria.Rotina.PACIENTE);
        } catch (SQLException ex) {
            ExceptionController.tratar(ex, paciente);
        }
    }

    public DefaultComboBoxModel obterModelComboEscolaridade() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
      
        for (Paciente.Escolaridade gp : Paciente.Escolaridade.values()) {
            combo.addElement(gp);
        }

        return combo;
    }
    
    public DefaultComboBoxModel obterModelComboEstadoCivil() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
      
        for (Paciente.EstadoCivil gp : Paciente.EstadoCivil.values()) {
            combo.addElement(gp);
        }

        return combo;
    }
    
    public DefaultComboBoxModel obterModelComboTipoMoradia() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
      
        for (Paciente.TipoMoradia gp : Paciente.TipoMoradia.values()) {
            combo.addElement(gp);
        }

        return combo;
    }

}
