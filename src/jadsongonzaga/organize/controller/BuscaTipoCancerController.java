
package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Busca;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jadson
 */
public class BuscaTipoCancerController {

    private final List<Busca> condicoes;
    private final List<Busca> ordens;
    BuscaController busca;
    
    public BuscaTipoCancerController() {
         
        String sql;
        condicoes = new LinkedList<>();
        ordens = new LinkedList<>();
        condicoes.add(new Busca("id", "Identificador", Busca.TipoDado.INTEIRO));
        condicoes.add(new Busca("descricao", "Descrição", Busca.TipoDado.STRING));
        ordens.add(new Busca("id", "Identificador", Busca.TipoDado.INTEIRO));
        ordens.add(new Busca("nome", "Descrição", Busca.TipoDado.STRING));
        sql = "SELECT "
           + "  id, "
           + "  descricao as descrição " 
           + "FROM"
           + "  tipo_cancer ";
        
        busca = new BuscaController(condicoes, ordens, sql);
             
    }
    
    public BuscaController getBuscaController(){
        return busca;
    }
    
    
    
    
}
