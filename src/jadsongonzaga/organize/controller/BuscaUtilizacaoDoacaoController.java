
package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Busca;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jadson
 */
public class BuscaUtilizacaoDoacaoController {

    
    private final List<Busca> condicoes;
    private final List<Busca> ordens;
    BuscaController busca;
    
    public BuscaUtilizacaoDoacaoController() {
         
        String sql;
        condicoes = new LinkedList<>();
        ordens = new LinkedList<>();
        condicoes.add(new Busca("udo.id", "Identificador", Busca.TipoDado.INTEIRO));
        condicoes.add(new Busca("tps.descricao", "Tipo do serviço", Busca.TipoDado.STRING));
        
        ordens.add(new Busca("udo.id", "Identificador", Busca.TipoDado.INTEIRO));
        ordens.add(new Busca("tps.descricao", "Tipo do serviço", Busca.TipoDado.STRING));
        
        sql = "SELECT "
           + "  udo.id AS Identificador, "
           + "  tps.descricao AS \"tipo do Serviço\","
           + "  udo.quantidade "
           + "FROM"
           + "  utilizacao_doacao udo"
           + "  INNER JOIN tipo_servico tps ON udo.tipo_servico_id = tps.id";
        
        busca = new BuscaController(condicoes, ordens, sql);
             
    }
    
    public BuscaController getBuscaController(){
        return busca;
    }
}
