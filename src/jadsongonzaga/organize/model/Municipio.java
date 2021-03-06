
package jadsongonzaga.organize.model;

/**
 *
 * @author jadson
 */
public class Municipio {
    
    private int id;
    private String nome;
    private Estado estado;

    public Municipio(){
        
    }
    
    public Municipio(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.estado.getNome();
    }

    @Override
    public boolean equals(Object obj) {
        return this.id == ((Municipio) obj).getId();
    }

    
}
