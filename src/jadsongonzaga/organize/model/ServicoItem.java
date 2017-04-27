
package jadsongonzaga.organize.model;

import java.math.BigDecimal;

/**
 *
 * @author jadson
 */
public class ServicoItem {
    
    private Servico servico;
    private TipoServico tipoServico;
    private BigDecimal quantidade;

    public ServicoItem(){
        
    }
    
    public ServicoItem(Servico servico, TipoServico tipoServico) {
        this.servico = servico;
        this.tipoServico = tipoServico;
    }
    

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
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

}
