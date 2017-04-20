
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
public class TipoServicoDAO {
    
    Connection conexao;
 
    /**
     * Persiste uma TipoServico, atualiza o ID da referencia
     *
     * @param tipoServico
     * @throws SQLException
     */
    public void inserir(TipoServico tipoServico) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "INSERT INTO tipo_servico (descricao) VALUES (?)";
        PreparedStatement pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, tipoServico.getDescricao());
        
        pst.execute();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            tipoServico.setId(rs.getInt(1));
        }
        conexao.close();

    }

    /**
     *
     * @param tipoServico
     * @throws SQLException
     */
    public void alterar(TipoServico tipoServico) throws SQLException {
        
        
        conexao = new Conexao().conectar();
        String sql = "UPDATE tipo_servico SET descricao = ? WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setString(1, tipoServico.getDescricao());
        
        pst.setInt(2, tipoServico.getId());

        pst.execute();

        conexao.close();
    }

    public void excluir(TipoServico tipoServico) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "DELETE FROM tipo_servico WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setInt(1, tipoServico.getId());

        pst.execute();

        conexao.close();
    }

    /**
     * Retorna o TipoServico a partir do ID
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public TipoServico obter(int id) throws SQLException {
        TipoServico tipoServico = null;
        
        conexao = new Conexao().conectar();

        String sql = "SELECT"
                    + "  descricao "
                    + "FROM"
                    + "  tipo_servico "
                    + "WHERE"
                    + "  id = ?";
        
        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            tipoServico = new TipoServico();
            
            tipoServico.setId(id);
            tipoServico.setDescricao(rs.getString("descricao")); 
        }

        conexao.close();

        return tipoServico;
    }
    
    public List<TipoServico> obter() throws SQLException {
        List<TipoServico> tipoServicos = new LinkedList<>();
        TipoServico tipoServico;
        
        conexao = new Conexao().conectar();

        String sql = "SELECT"
                    + "  id,"
                    + "  descricao "
                    + "FROM"
                    + "  tipo_servico ";
        
        PreparedStatement pst = conexao.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            tipoServico = new TipoServico();
            
            tipoServico.setId(rs.getInt("id"));
            tipoServico.setDescricao(rs.getString("descricao"));
            tipoServicos.add(tipoServico);
        }

        conexao.close();

        return tipoServicos;
    }
}
