
package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.view.Exercao;

/**
 *
 * @author jadson
 */
public class ExceptionController {
    
    public static void tratar(Exception ex, Object obj){
        
        String mensagem = ex.getMessage() + "\nObjeto:\n" + obj.toString();
        Log.gravar(mensagem);
        abrirForm(mensagem);
        
        ex.printStackTrace();
    }
    
    public static void tratar(Exception ex){
        
        String mensagem = ex.getMessage();
        
        Log.gravar(mensagem);
        abrirForm(mensagem);
        
        ex.printStackTrace();
    }
    
    private static void abrirForm(String mensagem){
        Exercao exercao = new Exercao(null, true, mensagem);
        exercao.setLocationRelativeTo(null);
        exercao.setVisible(true);
    }
}
