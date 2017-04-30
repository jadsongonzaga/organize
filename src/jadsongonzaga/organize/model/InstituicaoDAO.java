
package jadsongonzaga.organize.model;

import jadsongonzaga.organize.controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author jadson
 */
public class InstituicaoDAO {
    
    Connection conexao;
 
    /**
     * Persiste uma Instituicao, atualiza o ID da referencia
     *
     * @param instituicao
     * @throws SQLException
     */
    public void inserir(Instituicao instituicao) throws SQLException {
        new EnderecoDAO().inserir(instituicao.getEndereco());
        conexao = new Conexao().conectar();
        String sql = "INSERT INTO instituicao (razao_social, nome_fantasia, endereco_id, documento, logo) VALUES (?,?,?,?,?)";
        PreparedStatement pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        pst.setString(1, instituicao.getRazaoSocial());
        pst.setString(2, instituicao.getNomeFantasia());
        pst.setInt(3, instituicao.getEndereco().getId());
        pst.setString(4, instituicao.getDocumento());
        pst.setBytes(5, instituicao.getLogo());
        
        pst.execute();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            instituicao.setId(rs.getInt(1));
        }
        conexao.close();

    }

    /**
     *
     * @param instituicao
     * @throws SQLException
     */
    public void alterar(Instituicao instituicao) throws SQLException {
        
        
        conexao = new Conexao().conectar();
        String sql = "UPDATE instituicao SET razao_social = ?, nome_fantasia = ?, endereco_id = ?, documento = ?, logo = ? WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

         pst.setString(1, instituicao.getRazaoSocial());
        pst.setString(2, instituicao.getNomeFantasia());
        pst.setInt(3, instituicao.getEndereco().getId());
        pst.setString(4, instituicao.getDocumento());
        pst.setBytes(5, instituicao.getLogo());
        
        pst.setInt(6, instituicao.getId());

        pst.execute();

        conexao.close();
    }

    /**
     * Retorna o Instituicao a partir do ID
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Instituicao obter() throws SQLException {
        Instituicao instituicao = null;
        
        conexao = new Conexao().conectar();

        String sql = "SELECT"
                    + "  id,"
                    + "  razao_social,"
                    + "  nome_fantasia,"
                    + "  endereco_id,"
                    + "  documento,"
                    + "  logo "
                    + "FROM"
                    + "  instituicao "
                    + "LIMIT 1";
        
        PreparedStatement pst = conexao.prepareStatement(sql);
        
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            instituicao = new Instituicao();
            
            instituicao.setId(rs.getInt("id"));
            instituicao.setRazaoSocial(rs.getString("razao_social"));
            instituicao.setNomeFantasia(rs.getString("nome_fantasia"));
            instituicao.setDocumento(rs.getString("documento"));
            instituicao.setEndereco(new EnderecoDAO().obter(rs.getInt("endereco_id")));
            instituicao.setLogo(rs.getBytes("logo"));
        }

        conexao.close();

        return instituicao;
    }

}
