
package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.Organize;
import jadsongonzaga.organize.model.Auditoria;
import jadsongonzaga.organize.model.Usuario;
import jadsongonzaga.organize.model.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author jadson
 */
public class UsuarioController {
    
    private final UsuarioDAO dao;
    private final AuditoriaController auditoria;

    public UsuarioController() {
        dao = new UsuarioDAO();
        auditoria = new AuditoriaController();
    }

    public void salvar(Usuario usuario, boolean inserir) {

        try {

            if (inserir) {
                dao.inserir(usuario);
                auditoria.salvarInserir(usuario.getId(), Auditoria.Rotina.USUARIO);
            } else {
                dao.alterar(usuario);
                auditoria.salvarAlterar(usuario.getId(), Auditoria.Rotina.USUARIO);
            }

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, usuario);
        }

    }

    public void excluir(Usuario usuario) {
        try {

            dao.excluir(usuario);
            auditoria.salvarDeletar(usuario.getId(), Auditoria.Rotina.USUARIO);

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, usuario);
        }
    }

    public Usuario obter(int id) {

        Usuario usuario = null;
        try {
            usuario = dao.obter(id);
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }
        return usuario;
    }
    
    public DefaultComboBoxModel obterModelCombo() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        List<Usuario> lUsuario = new ArrayList<>();
        try {
            lUsuario = dao.obter();
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }

        for (Usuario tc : lUsuario) {
            combo.addElement(tc);
        }

        return combo;
    }
    
    public DefaultComboBoxModel obterModelComboTipo() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
      
        for (Usuario.Tipo tipo : Usuario.Tipo.values()) {
            combo.addElement(tipo);
        }

        return combo;
    }
    
    public boolean loginAutorizado(String login, String senha){
     
        Usuario usr;
        try {
            usr = dao.obter(login);
            if(usr != null && usr.getSenha().equals(senha)){
                Organize.USUARIO = usr;
                return true;
            }
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }
        
        return false;
    }
    
    public Usuario obter(String login) {

        Usuario usuario = null;
        try {
            usuario = dao.obter(login);
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }
        return usuario;
    }
}