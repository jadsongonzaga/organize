
package jadsongonzaga.organize.model;

import java.math.BigDecimal;

/**
 *
 * @author jadson
 */
public class UtilizacaoDoacao {

    private int id;
    private TipoServico tipoServico;
    private BigDecimal quantidade;
    private String observacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return this.tipoServico.toString() + " - " + this.quantidade;
    }
    
    
    
}
