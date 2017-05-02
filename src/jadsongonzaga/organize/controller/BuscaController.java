package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Busca;
import jadsongonzaga.organize.model.BuscaDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author jadson
 */
public class BuscaController {

    private final BuscaDAO dao;
    private final List<Busca> condicoes;
    private final List<Busca> ordens;
    private final String sql;


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
        } catch (SQLException | NumberFormatException ex) {
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
