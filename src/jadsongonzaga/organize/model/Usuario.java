
package jadsongonzaga.organize.model;

/**
 *
 * @author jadson
 */
public class Usuario {
    private int id;
    private String nome;
    private String login;
    private String senha;
    private Tipo tipo;

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    
    public enum Tipo{
        ADMINISTRADOR(1, "Administrador"), FINANCEIRO(2, "Financeiro"), ATENDIMENTO(3,"Atendimento");

        private final int id;
        private final String descricao;
        
        private Tipo(int id, String descricao) {
            this.id = id;
            this.descricao = descricao;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return this.descricao;
        }
        
        public static Tipo valueOfId(int id){
            
            for (Tipo tipo : values()) {
                if(tipo.getId() == id){
                    return tipo;
                }
            }
            return null;
        }
        
        
        
        
        
        
        
    }
}
