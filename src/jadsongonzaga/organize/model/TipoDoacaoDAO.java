
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
public class TipoDoacaoDAO {
    
    Connection conexao;
 
    /**
     * Persiste uma TipoDoacao, atualiza o ID da referencia
     *
     * @param tipoDoacao
     * @throws SQLException
     */
    public void inserir(TipoDoacao tipoDoacao) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "INSERT INTO tipo_doacao (descricao) VALUES (?)";
        PreparedStatement pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, tipoDoacao.getDescricao());
        
        pst.execute();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            tipoDoacao.setId(rs.getInt(1));
        }
        conexao.close();

    }

    /**
     *
     * @param tipoDoacao
     * @throws SQLException
     */
    public void alterar(TipoDoacao tipoDoacao) throws SQLException {
        
        
        conexao = new Conexao().conectar();
        String sql = "UPDATE tipo_doacao SET descricao = ? WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setString(1, tipoDoacao.getDescricao());
        
        pst.setInt(2, tipoDoacao.getId());

        pst.execute();

        conexao.close();
    }

    public void excluir(TipoDoacao tipoDoacao) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "DELETE FROM tipo_doacao WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setInt(1, tipoDoacao.getId());

        pst.execute();

        conexao.close();
    }

    /**
     * Retorna o TipoDoacao a partir do ID
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public TipoDoacao obter(int id) throws SQLException {
        TipoDoacao tipoDoacao = null;
        
        conexao = new Conexao().conectar();

        String sql = "SELECT"
                    + "  descricao "
                    + "FROM"
                    + "  tipo_doacao "
                    + "WHERE"
                    + "  id = ?";
        
        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            tipoDoacao = new TipoDoacao();
            
            tipoDoacao.setId(id);
            tipoDoacao.setDescricao(rs.getString("descricao")); 
        }

        conexao.close();

        return tipoDoacao;
    }
    
    public List<TipoDoacao> obter() throws SQLException {
        List<TipoDoacao> tipoDoacaos = new LinkedList<>();
        TipoDoacao tipoDoacao;
        
        conexao = new Conexao().conectar();

        String sql = "SELECT"
                    + "  id,"
                    + "  descricao "
                    + "FROM"
                    + "  tipo_doacao ";
        
        PreparedStatement pst = conexao.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            tipoDoacao = new TipoDoacao();
            
            tipoDoacao.setId(rs.getInt("id"));
            tipoDoacao.setDescricao(rs.getString("descricao"));
            tipoDoacaos.add(tipoDoacao);
        }

        conexao.close();

        return tipoDoacaos;
    }
}
