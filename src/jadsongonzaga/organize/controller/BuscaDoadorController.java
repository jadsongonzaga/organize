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
public class BuscaDoadorController {
    
    private final List<Busca> condicoes;
    private final List<Busca> ordens;
    BuscaController busca;
    
    public BuscaDoadorController() {
         
        String sql;
        condicoes = new LinkedList<>();
        ordens = new LinkedList<>();
        condicoes.add(new Busca("id", "Identificador", Busca.TipoDado.INTEIRO));
        condicoes.add(new Busca("nome", "Nome", Busca.TipoDado.STRING));
        ordens.add(new Busca("id", "Identificador", Busca.TipoDado.INTEIRO));
        ordens.add(new Busca("nome", "Nome", Busca.TipoDado.STRING));
        sql = "SELECT "
           + "  id, "
           + "  nome,"
           + "  cpf " 
           + "FROM"
           + "  doador ";
        
        busca = new BuscaController(condicoes, ordens, sql);
             
    }
    
    public BuscaController getBuscaController(){
        return busca;
    }
}
