
package jadsongonzaga.organize.view;

import java.awt.Component;

/**
 *
 * @author jadson
 */
public class ComponenteInfo {
    private Component componente;
    private String nome;

    public ComponenteInfo(Component componente, String nome) {
        this.componente = componente;
        this.nome = nome;
    }

    public Component getComponente() {
        return componente;
    }

    public void setComponente(Component componente) {
        this.componente = componente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
