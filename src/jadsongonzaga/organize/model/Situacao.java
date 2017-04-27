package jadsongonzaga.organize.model;

/**
 * Enum de Situação contendo os valores:<br>
 * <blockquote><pre>
 *     ABERTO - 1
 *     FECHADO - 2
 *     CANCELADO -3 
 * </pre></blockquote>
 * @author jadson
 */
public enum Situacao {
    /**
     * Aberto - 1
     */
    ABERTO(1, "Aberto"),
    /**
     * Fechado -2
     */
    FECHADO(2, "Fechado"),
    /**
     * Cancelado - 3
     */
    CANCELADO(3, "Cancelado");
    
    private final int id;
    private final String descricao;

    private Situacao(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public static Situacao valueOfId(int id){
        for (Situacao value : values()) {
            if(value.getId() == id)
                return value;
        }
        return null;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
    
    

}
