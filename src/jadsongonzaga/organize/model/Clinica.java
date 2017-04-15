

package jadsongonzaga.organize.model;

/**
 *
 * @author jadson
 */
public class Clinica {
    private int id;
    private String nome;
    private String telefone;
    private String contato;   

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public boolean equals(Object obj) {
        return this.id == ((Clinica) obj).getId();
    }

    
    
}
