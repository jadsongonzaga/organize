
package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Busca;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jadson
 */
public class BuscaAcompanhanteController {

    private final List<Busca> condicoes;
    private final List<Busca> ordens;
    BuscaController busca;
    
    public BuscaAcompanhanteController() {
         
        String sql;
        condicoes = new LinkedList<>();
        ordens = new LinkedList<>();
        condicoes.add(new Busca("aco.id", "Identificador", Busca.TipoDado.INTEIRO));
        condicoes.add(new Busca("pes.nome", "Nome", Busca.TipoDado.STRING));
        ordens.add(new Busca("aco.id", "Identificador", Busca.TipoDado.INTEIRO));
        ordens.add(new Busca("pes.nome", "Nome", Busca.TipoDado.STRING));
        sql = "SELECT "
           + "  aco.id as Identificador, "
           + "  pes.nome as Nome, " 
           + "  pes.rg as RG," 
           + "  mun.nome as Munícipio,"
           + "  est.nome as Estado "
           + "FROM"
           + "  acompanhante aco"
           + "  INNER JOIN pessoa pes on aco.id = pes.id"
           + "  INNER JOIN endereco en on pes.endereco_id = en.id"
           + "  INNER JOIN municipio mun on en.municipio_id = mun.id"
           + "  INNER JOIN estado est on mun.estado_id = est.id";
        
        busca = new BuscaController(condicoes, ordens, sql);
             
    }
    
    public BuscaController getBuscaController(){
        return busca;
    }
    
    
    
    
}
