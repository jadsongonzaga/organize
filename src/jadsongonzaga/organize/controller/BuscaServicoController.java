/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Busca;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jadson
 */
public class BuscaServicoController {
    
    private final List<Busca> condicoes;
    private final List<Busca> ordens;
    BuscaController busca;
    
    public BuscaServicoController() {
         
        String sql;
        condicoes = new LinkedList<>();
        ordens = new LinkedList<>();
        condicoes.add(new Busca("ser.id", "Identificador", Busca.TipoDado.INTEIRO));
        condicoes.add(new Busca("ser.descricao", "Descrição", Busca.TipoDado.STRING));
        ordens.add(new Busca("ser.id", "Identificador", Busca.TipoDado.INTEIRO));
        ordens.add(new Busca("ser.descricao", "Descrição", Busca.TipoDado.STRING));
        sql = "SELECT "
           + "  ser.id as identificador, "
           + "  ser.descricao as descrição, " 
           + "  pac.id as \"Código paciente\"," 
           + "  pes.nome," 
           + "  CASE (ser.situacao) WHEN 1 THEN 'Aberto' " 
           + "                      WHEN 2 THEN 'Fechado'" 
           + "                      WHEN 3 THEN 'Cancelado' END as situação " 
           + "FROM"
           + "  servico ser "
           + "  INNER JOIN paciente pac on ser.paciente_id = pac.id"
           + "  INNER JOIN pessoa pes on pac.id = pes.id";
        
        busca = new BuscaController(condicoes, ordens, sql);
             
    }
    
    public BuscaController getBuscaController(){
        return busca;
    }
}
