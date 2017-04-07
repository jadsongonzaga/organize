
package jadsongonzaga.organize.model;

import jadsongonzaga.organize.controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
    public List<Map<String, Object>>  busca(String sql) throws SQLException{

        conexao = new Conexao().conectar();
        List<String> campos = new LinkedList();
        List<Map<String, Object>>  valores = new LinkedList<>();
        Map<String, Object> map;
        PreparedStatement pst = conexao.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        int quantidadeColuna = pst.getMetaData().getColumnCount();

        for (int i = 1 ; i <= quantidadeColuna; i++) {
            campos.add(pst.getMetaData().getColumnName(i));
        }
        
        

        while(rs.next()){
            map = new LinkedHashMap<>();
            for (String campo : campos) {
                map.put(campo, rs.getObject(campo));
            }
            
            valores.add(map);
        }

        
        return valores;

    }
    
    public List<Map<String, Object>>  busca(String sql, Busca oredem, Busca condicao, String valor) throws SQLException{

        conexao = new Conexao().conectar();
        List<String> campos = new LinkedList();
        List<Map<String, Object>>  valores = new LinkedList<>();
        Map<String, Object> map;
        
        String operadorBusca = (condicao.getTipoDado() == Busca.TipoDado.STRING) ? " LIKE ? " : " = ?";
        
        String sqlCondicao = " WHERE " + condicao.getCampo() + operadorBusca;
        String sqlOrdem = " ORDER BY " + oredem.getCampo();
        
        sql = sql + sqlCondicao + sqlOrdem;
        
        System.out.println(sql);
        PreparedStatement pst = conexao.prepareStatement(sql);
        
        if(condicao.getTipoDado() == Busca.TipoDado.INTEIRO){
            pst.setInt(1, Integer.parseInt(valor));
        }else if(condicao.getTipoDado() == Busca.TipoDado.STRING){
            pst.setString(1, "%"+valor+"%");
        }
        
        ResultSet rs = pst.executeQuery();

        int quantidadeColuna = pst.getMetaData().getColumnCount();

        for (int i = 1 ; i <= quantidadeColuna; i++) {
            campos.add(pst.getMetaData().getColumnName(i));
        }
        
        

        while(rs.next()){
            map = new LinkedHashMap<>();
            for (String campo : campos) {
                map.put(campo, rs.getObject(campo));
            }
            
            valores.add(map);
        }

        
        return valores;

    }
    
    public static void main(String[] args) throws SQLException {
        String sql =    "SELECT " +
                        "  aco.id as Identificador, " +
                        "  pes.nome as Nome, " +
                        "  pes.rg as RG," +
                        "  mun.nome as Munícipio," +
                        "  est.nome as Estado " +
                
                        "FROM" +
                        "  acompanhante aco" +
                        "  INNER JOIN pessoa pes on aco.id = pes.id" +
                        "  INNER JOIN endereco en on pes.endereco_id = en.id" +
                        "  INNER JOIN municipio mun on en.municipio_id = mun.id" +
                        "  INNER JOIN estado est on mun.estado_id = est.id";
        
        
        
        System.out.println(new BuscaDAO().busca(sql).get(0));
        System.out.println(new BuscaDAO().busca(sql).get(1));
    }
    
    
}
