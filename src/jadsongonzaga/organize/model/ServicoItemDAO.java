
package jadsongonzaga.organize.model;

import jadsongonzaga.organize.controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jadson
 */
public class ServicoItemDAO {
    
    Connection conexao;
 
    /**
     * Persiste uma ServicoItem, atualiza o ID da referencia
     *
     * @param servicoItem
     * @throws SQLException
     */
    public void inserir(ServicoItem servicoItem) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "INSERT INTO servico_item (servico_id, tipo_servico_id, quantidade) VALUES (?,?,?)";
        PreparedStatement pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        pst.setInt(1, servicoItem.getServico().getId());
        pst.setInt(2, servicoItem.getTipoServico().getId());
        pst.setBigDecimal(3, servicoItem.getQuantidade());
        
        pst.execute();
        
        conexao.close();

    }

    /**
     *
     * @param servicoItem
     * @throws SQLException
     */
    public void alterar(ServicoItem servicoItem) throws SQLException {

        conexao = new Conexao().conectar();
        String sql = "UPDATE servico_item SET quantidade = ? WHERE servico_id = ? AND tipo_servico_id= ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setBigDecimal(1, servicoItem.getQuantidade());
        
        pst.setInt(2, servicoItem.getServico().getId());
        pst.setInt(3, servicoItem.getTipoServico().getId());
        
        pst.execute();

        conexao.close();
    }

    public void excluir(ServicoItem servicoItem) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "DELETE FROM servico_item WHERE servico_id = ? AND tipo_servico_id= ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setInt(1, servicoItem.getServico().getId());
        pst.setInt(2, servicoItem.getTipoServico().getId());
        
        pst.execute();

        conexao.close();
    }
    
    public void excluir(Servico servico) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "DELETE FROM servico_item WHERE servico_id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setInt(1, servico.getId());
        
        pst.execute();

        conexao.close();
    }

    /**
     * Retorna o ServicoItem a partir do ID
     *
     * @param servico
     * @param tipoServico
     * @return
     * @throws SQLException
     */
    public ServicoItem obter(Servico servico, TipoServico tipoServico) throws SQLException {
        ServicoItem servicoItem = null;
        
        conexao = new Conexao().conectar();
        
        String sql =  "SELECT"
                    + "  quantidade "
                    + "FROM"
                    + "  servico_item "
                    + "WHERE"
                    + "  servico_id = ? AND"
                    + "  tipo_servico_id = ?";
        
        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, servico.getId());
        pst.setInt(2, tipoServico.getId());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            servicoItem = new ServicoItem();
            
            servicoItem.setQuantidade(rs.getBigDecimal("quantidade")); 
            servicoItem.setTipoServico(tipoServico);

        }

        conexao.close();

        return servicoItem;
    }
    
    public List<ServicoItem> obter(Servico servico) throws SQLException {
        List<ServicoItem> servicoItems = new LinkedList<>();
        ServicoItem servicoItem;
        
        conexao = new Conexao().conectar();
        
        String sql =  "SELECT"
                    + "  quantidade, "
                    + "  tipo_servico_id "
                    + "FROM"
                    + "  servico_item "
                    + "WHERE"
                    + "  servico_id = ? ";
        
        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, servico.getId());
        
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            servicoItem = new ServicoItem();
            
            servicoItem.setQuantidade(rs.getBigDecimal("quantidade")); 
            servicoItem.setTipoServico(new TipoServicoDAO().obter(rs.getInt("tipo_servico_id")));

        
            servicoItems.add(servicoItem);

        }

        conexao.close();

        return servicoItems;
    }
}
