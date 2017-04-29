
package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Busca;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jadson
 */
public class BuscaDoacaoController {
    
    private final List<Busca> condicoes;
    private final List<Busca> ordens;
    BuscaController busca;
    
    public BuscaDoacaoController() {
         
        String sql;
        condicoes = new LinkedList<>();
        ordens = new LinkedList<>();
        condicoes.add(new Busca("doa.id", "Identificador", Busca.TipoDado.INTEIRO));
        condicoes.add(new Busca("tdo.descricao", "Tipo da doação", Busca.TipoDado.STRING));
        condicoes.add(new Busca("ddr.nome", "Doador", Busca.TipoDado.STRING));
        ordens.add(new Busca("doa.id", "Identificador", Busca.TipoDado.INTEIRO));
        ordens.add(new Busca("tdo.descricao", "Tipo da doação", Busca.TipoDado.STRING));
        ordens.add(new Busca("ddr.nome", "Doador", Busca.TipoDado.STRING));
        sql = "SELECT "
           + "  doa.id, "
           + "  tdo.descricao as \"tipo da doação\","
           + "  doa.quantidade, " 
           + "  ddr.nome as \"doador\" " 
           + "FROM"
           + "  doacao doa"
           + "  INNER JOIN doador ddr on doa.doador_id = ddr.id"
           + "  INNER JOIN tipo_doacao tdo on doa.tipo_doacao_id = tdo.id ";
        
        busca = new BuscaController(condicoes, ordens, sql);
             
    }
    
    public BuscaController getBuscaController(){
        return busca;
    }
}
