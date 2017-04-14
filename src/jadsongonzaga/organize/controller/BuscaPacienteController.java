
package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Busca;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jadson
 */
public class BuscaPacienteController {
    
    private final List<Busca> condicoes;
    private final List<Busca> ordens;
    BuscaController busca;
    
    public BuscaPacienteController() {
         
        String sql;
        condicoes = new LinkedList<>();
        ordens = new LinkedList<>();
        condicoes.add(new Busca("pac.id", "Identificador", Busca.TipoDado.INTEIRO));
        condicoes.add(new Busca("pes.nome", "Nome", Busca.TipoDado.STRING));
        ordens.add(new Busca("pac.id", "Identificador", Busca.TipoDado.INTEIRO));
        ordens.add(new Busca("pes.nome", "Nome", Busca.TipoDado.STRING));
        sql = "SELECT "
           + "  pac.id as Identificador, "
           + "  pes.nome as Nome, " 
           + "  pes.rg as RG," 
           + "  mun.nome as Munícipio,"
           + "  est.nome as Estado, "
           + "  paco.nome as acompanhate "
           + "FROM"
           + "  paciente pac"
           + "  INNER JOIN pessoa pes on pac.id = pes.id"
           + "  INNER JOIN endereco en on pes.endereco_id = en.id"
           + "  INNER JOIN municipio mun on en.municipio_id = mun.id"
           + "  INNER JOIN estado est on mun.estado_id = est.id"
           + "  LEFT JOIN acompanhante aco on pac.acompanhante_id = aco.id"
           + "  LEFT JOIN pessoa paco on aco.id = paco.id";
        
        busca = new BuscaController(condicoes, ordens, sql);
             
    }
    
    public BuscaController getBuscaController(){
        return busca;
    }
    
}
