
package jadsongonzaga.organize.model;

import java.time.LocalDate;

/**
 *
 * @author jadson
 */
public class Login {
    
    private int id;
    private Usuario usuario;
    private LocalDate instate;

    public Login() {
    }

    public Login(Usuario usuario) {
        this.usuario = usuario;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getInstate() {
        return instate;
    }

    public void setInstate(LocalDate instate) {
        this.instate = instate;
    }
    
    
    
}
