
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
public class TipoCancerDAO {
    
    Connection conexao;
 
    /**
     * Persiste uma TipoCancer, atualiza o ID da referencia
     *
     * @param tipoCancer
     * @throws SQLException
     */
    public void inserir(TipoCancer tipoCancer) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "INSERT INTO tipo_cancer (descricao) VALUES (?)";
        PreparedStatement pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, tipoCancer.getDescricao());
        
        pst.execute();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            tipoCancer.setId(rs.getInt(1));
        }
        conexao.close();

    }

    /**
     *
     * @param tipoCancer
     * @throws SQLException
     */
    public void alterar(TipoCancer tipoCancer) throws SQLException {
        
        
        conexao = new Conexao().conectar();
        String sql = "UPDATE tipo_cancer SET descricao = ? WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setString(1, tipoCancer.getDescricao());
        
        pst.setInt(2, tipoCancer.getId());

        pst.execute();

        conexao.close();
    }

    public void excluir(TipoCancer tipoCancer) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "DELETE FROM tipo_cancer WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setInt(1, tipoCancer.getId());

        pst.execute();

        conexao.close();
    }

    /**
     * Retorna o TipoCancer a partir do ID
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public TipoCancer obter(int id) throws SQLException {
        TipoCancer tipoCancer = null;
        
        conexao = new Conexao().conectar();

        String sql = "SELECT"
                    + "  descricao "
                    + "FROM"
                    + "  tipo_cancer "
                    + "WHERE"
                    + "  id = ?";
        
        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            tipoCancer = new TipoCancer();
            
            tipoCancer.setId(id);
            tipoCancer.setDescricao(rs.getString("descricao")); 
        }

        conexao.close();

        return tipoCancer;
    }
    
    public List<TipoCancer> obter() throws SQLException {
        List<TipoCancer> tipoCancers = new LinkedList<>();
        TipoCancer tipoCancer;
        
        conexao = new Conexao().conectar();

        String sql = "SELECT"
                    + "  id,"
                    + "  descricao "
                    + "FROM"
                    + "  tipo_cancer ";
        
        PreparedStatement pst = conexao.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            tipoCancer = new TipoCancer();
            
            tipoCancer.setId(rs.getInt("id"));
            tipoCancer.setDescricao(rs.getString("descricao"));
            tipoCancers.add(tipoCancer);
        }

        conexao.close();

        return tipoCancers;
    }
}
