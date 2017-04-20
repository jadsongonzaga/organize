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
public class BuscaTipoServicoController {
    
    private final List<Busca> condicoes;
    private final List<Busca> ordens;
    BuscaController busca;
    
    public BuscaTipoServicoController() {
         
        String sql;
        condicoes = new LinkedList<>();
        ordens = new LinkedList<>();
        condicoes.add(new Busca("id", "Identificador", Busca.TipoDado.INTEIRO));
        condicoes.add(new Busca("descricao", "Descrição", Busca.TipoDado.STRING));
        ordens.add(new Busca("id", "Identificador", Busca.TipoDado.INTEIRO));
        ordens.add(new Busca("descricao", "Descrição", Busca.TipoDado.STRING));
        sql = "SELECT "
           + "  id, "
           + "  descricao as descrição " 
           + "FROM"
           + "  tipo_servico ";
        
        busca = new BuscaController(condicoes, ordens, sql);
             
    }
    
    public BuscaController getBuscaController(){
        return busca;
    }    
}