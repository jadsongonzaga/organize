
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
public class DoacaoDAO {
    //    //id, doador_id, tipo_doacao_id, quantidade, observacao
    
    
    Connection conexao;
 
    /**
     * Persiste uma Doacao, atualiza o ID da referencia
     *
     * @param doacao
     * @throws SQLException
     */
    public void inserir(Doacao doacao) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "INSERT INTO doacao (doador_id, tipo_doacao_id, quantidade, observacao) VALUES (?,?,?,?)";
        PreparedStatement pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setInt(1, doacao.getDoador().getId());
        pst.setInt(2, doacao.getTipoDoacao().getId());
        pst.setBigDecimal(3, doacao.getQuantidade());
        pst.setString(4, doacao.getObservacao());
        
        pst.execute();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            doacao.setId(rs.getInt(1));
        }
        conexao.close();

    }

    /**
     *
     * @param doacao
     * @throws SQLException
     */
    public void alterar(Doacao doacao) throws SQLException {
        
        
        conexao = new Conexao().conectar();
        String sql = "UPDATE doacao SET doador_id = ?, tipo_doacao_id = ?, quantidade = ?, observacao = ? WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setInt(1, doacao.getDoador().getId());
        pst.setInt(2, doacao.getTipoDoacao().getId());
        pst.setBigDecimal(3, doacao.getQuantidade());
        pst.setString(4, doacao.getObservacao());
        
        pst.setInt(5, doacao.getId());

        pst.execute();

        conexao.close();
    }

    public void excluir(Doacao doacao) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "DELETE FROM doacao WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setInt(1, doacao.getId());

        pst.execute();

        conexao.close();
    }

    /**
     * Retorna o Doacao a partir do ID
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Doacao obter(int id) throws SQLException {
        Doacao doacao = null;
        
        conexao = new Conexao().conectar();

        String sql = "SELECT"
                    + "  id,"
                    + "  doador_id,"
                    + "  tipo_doacao_id,"
                    + "  quantidade, "
                    + "  observacao "
                    + "FROM"
                    + "  doacao "
                    + "WHERE"
                    + "  id = ?";
        
        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            doacao = new Doacao();
            
            doacao.setId(id);
            doacao.setDoador(new DoadorDAO().obter(rs.getInt("doador_id")));
            doacao.setTipoDoacao(new TipoDoacaoDAO().obter(rs.getInt("tipo_doacao_id")));
            doacao.setQuantidade(rs.getBigDecimal("quantidade"));
            doacao.setObservacao(rs.getString("observacao"));
        }

        conexao.close();

        return doacao;
    }
    
}
