/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadsongonzaga.organize;

import jadsongonzaga.organize.model.Usuario;
import jadsongonzaga.organize.view.LoginView;

/**
 *
 * @author jadson
 */
public class Organize {

    public static Usuario USUARIO;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Organize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        LoginView login = new LoginView(null, true);
        login.setVisible(true);

    }

}
