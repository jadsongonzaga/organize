package jadsongonzaga.organize.model;

import jadsongonzaga.organize.controller.Conexao;
import jadsongonzaga.organize.controller.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jadson
 */
public class BuscaDAO {

    Connection conexao;

    public List<Map<String, Object>> busca(String sql) throws SQLException {

        conexao = new Conexao().conectar();
        List<String> campos = new LinkedList();
        List<Map<String, Object>> valores = new LinkedList<>();
        Map<String, Object> map;
        PreparedStatement pst = conexao.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        int quantidadeColuna = pst.getMetaData().getColumnCount();

        for (int i = 1; i <= quantidadeColuna; i++) {
            campos.add(pst.getMetaData().getColumnName(i));
        }

        while (rs.next()) {
            map = new LinkedHashMap<>();
            for (String campo : campos) {
                map.put(campo, rs.getObject(campo));
            }

            valores.add(map);
        }

        return valores;

    }

    public List<Map<String, Object>> busca(String sql, Busca oredem, Busca condicao, String valor) throws SQLException, NumberFormatException {

        conexao = new Conexao().conectar();
        List<String> campos = new LinkedList();
        List<Map<String, Object>> valores = new LinkedList<>();
        Map<String, Object> map;
        PreparedStatement pst;

        String sqlOrdem = " ORDER BY " + oredem.getCampo();
        
        if (!valor.isEmpty()) {

            String operadorBusca = (condicao.getTipoDado() == Busca.TipoDado.STRING) ? " LIKE ? " : " = ?";

            String sqlCondicao = " WHERE " + condicao.getCampo() + operadorBusca;

            sql = sql + sqlCondicao + sqlOrdem;
            pst = conexao.prepareStatement(sql);

            if (condicao.getTipoDado() == Busca.TipoDado.INTEIRO) {
                if(Utils.eNumero(valor)){
                    pst.setInt(1, Integer.parseInt(valor));
                }else{
                    throw new NumberFormatException();
                }
            } else if (condicao.getTipoDado() == Busca.TipoDado.STRING) {
                pst.setString(1, "%" + valor + "%");
            }
        }else{
            sql += sqlOrdem;
            pst = conexao.prepareStatement(sql);
        }
        

        ResultSet rs = pst.executeQuery();

        int quantidadeColuna = pst.getMetaData().getColumnCount();

        for (int i = 1; i <= quantidadeColuna; i++) {
            campos.add(pst.getMetaData().getColumnName(i));
        }

        while (rs.next()) {
            map = new LinkedHashMap<>();
            for (String campo : campos) {
                map.put(campo, rs.getObject(campo));
            }

            valores.add(map);
        }

        return valores;

    }

}
