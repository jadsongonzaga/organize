package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Busca;
import jadsongonzaga.organize.model.BuscaDAO;
import jadsongonzaga.organize.model.Estado;
import jadsongonzaga.organize.model.Municipio;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author jadson
 */
public class BuscaController {

    private  BuscaDAO dao;
    private  List<Busca> condicoes;
    private  List<Busca> ordens;
    private  String sql;

    public BuscaController(){
        dao = new BuscaDAO();
        condicoes = new LinkedList<>();
        ordens = new LinkedList<>();
        condicoes.add(new Busca("aco.id", "Identificador", Busca.TipoDado.INTEIRO));
        condicoes.add(new Busca("pes.nome", "Nome", Busca.TipoDado.STRING));
        
        ordens.add(new Busca("aco.id", "Identificador", Busca.TipoDado.INTEIRO));
             sql = "SELECT "
                + "  aco.id as Identificador, "
                + "  pes.nome as Nome, "
                + //   "  pes.rg as RG," +
                "  mun.nome as Munícipio,"
                + "  est.nome as Estado "
                + "FROM"
                + "  acompanhante aco"
                + "  INNER JOIN pessoa pes on aco.id = pes.id"
                + "  INNER JOIN endereco en on pes.endereco_id = en.id"
                + "  INNER JOIN municipio mun on en.municipio_id = mun.id"
                + "  INNER JOIN estado est on mun.estado_id = est.id";
                
    }
    
    public BuscaController(List<Busca> condicoes, List<Busca> ordens, String sql) {
        dao = new BuscaDAO();
        this.condicoes = condicoes;
        this.ordens = ordens;
        this.sql = sql;
    }

    public List<Map<String, Object>> getDados() {
   

        List<Map<String, Object>> valores = null;
        try {
            valores = dao.busca(sql);
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }

        return valores;
    }
    
        public List<Map<String, Object>> getDados(Busca ordem, Busca condicao, String valor) {

        List<Map<String, Object>> valores = null;
        try {
            valores = dao.busca(sql, ordem, condicao, valor);
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }

        return valores;
    }

    public DefaultComboBoxModel obterModelComboCondicoes() {
        DefaultComboBoxModel combobox = new DefaultComboBoxModel();

        condicoes.forEach((busca) -> {
            combobox.addElement(busca);
        });

        return combobox;
    }

    public DefaultComboBoxModel obterModelComboOrdens() {
        DefaultComboBoxModel combobox = new DefaultComboBoxModel();

        ordens.forEach((busca) -> {
            combobox.addElement(busca);
        });

        return combobox;
    }
}
