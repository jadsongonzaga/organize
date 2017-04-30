
package jadsongonzaga.organize.model;

import jadsongonzaga.organize.controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * id, tipo_servico_id, quantidade, observacao
 * @author jadson
 */
public class UtilizacaoDoacaoDAO {
    
    Connection conexao;
 
    /**
     * Persiste uma UtilizacaoDoacao, atualiza o ID da referencia
     *
     * @param utilizacao
     * @throws SQLException
     */
    public void inserir(UtilizacaoDoacao utilizacao) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "INSERT INTO utilizacao_doacao (tipo_servico_id, quantidade, observacao) VALUES (?, ?, ?)";
        PreparedStatement pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setInt(1, utilizacao.getTipoServico().getId());
        pst.setBigDecimal(2, utilizacao.getQuantidade());
        pst.setString(3, utilizacao.getObservacao());
        
        pst.execute();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            utilizacao.setId(rs.getInt(1));
        }
        conexao.close();

    }

    /**
     *
     * @param utilizacao
     * @throws SQLException
     */
    public void alterar(UtilizacaoDoacao utilizacao) throws SQLException {
        
        
        conexao = new Conexao().conectar();
        String sql = "UPDATE utilizacao_doacao SET tipo_servico_id = ?, quantidade = ?, observacao = ? WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setInt(1, utilizacao.getTipoServico().getId());
        pst.setBigDecimal(2, utilizacao.getQuantidade());
        pst.setString(3, utilizacao.getObservacao());
        
        
        pst.setInt(4, utilizacao.getId());

        pst.execute();

        conexao.close();
    }

    public void excluir(UtilizacaoDoacao utilizacao) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "DELETE FROM utilizacao_doacao WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setInt(1, utilizacao.getId());

        pst.execute();

        conexao.close();
    }

    /**
     * Retorna o UtilizacaoDoacao a partir do ID
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public UtilizacaoDoacao obter(int id) throws SQLException {
        UtilizacaoDoacao utilizacao = null;
        
        conexao = new Conexao().conectar();

        String sql = "SELECT"
                    + "  tipo_servico_id,"
                    + "  quantidade,"
                    + "  observacao "
                    + "FROM"
                    + "  utilizacao_doacao "
                    + "WHERE"
                    + "  id = ?";
        
        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            utilizacao = new UtilizacaoDoacao();
            
            utilizacao.setId(id);
            utilizacao.setTipoServico(new TipoServicoDAO().obter(rs.getInt("tipo_servico_id"))); 
            utilizacao.setQuantidade(rs.getBigDecimal("quantidade")); 
            utilizacao.setObservacao(rs.getString("observacao")); 
        }

        conexao.close();

        return utilizacao;
    }
}