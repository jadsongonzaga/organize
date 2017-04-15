package jadsongonzaga.organize.model;

/**
 *
 * @author jadson
 */
public class TipoCancer {

    private int id;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }

    @Override
    public boolean equals(Object obj) {
        return this.id == ((TipoCancer) obj).getId();
    }
    
    
    

}
