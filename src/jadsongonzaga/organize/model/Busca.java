
package jadsongonzaga.organize.model;

/**
 *
 * @author jadson
 */
public class Busca {
    private String campo;
    private String nome;
    private TipoDado tipoDado;

    public Busca(String campo, String nome, TipoDado tipoDado) {
        this.campo = campo;
        this.nome = nome;
        this.tipoDado = tipoDado;
    }
    
    public Busca(){
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoDado getTipoDado() {
        return tipoDado;
    }

    public void setTipoDado(TipoDado tipoDado) {
        this.tipoDado = tipoDado;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public boolean equals(Object obj) {
        return this.campo.equals(((Busca)obj).getCampo());
    }
    
    public enum TipoDado{
        INTEIRO, STRING, DATA;
    }
    
}
