
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
public class ClinicaDAO {
    
    Connection conexao;
 
    /**
     * Persiste uma Clinica, atualiza o ID da referencia
     *
     * @param clinica
     * @throws SQLException
     */
    public void inserir(Clinica clinica) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "INSERT INTO clinica (nome, telefone, contato) VALUES (?,?,?)";
        PreparedStatement pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, clinica.getNome());
        pst.setString(2, clinica.getTelefone());
        pst.setString(3, clinica.getContato());
        
        pst.execute();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            clinica.setId(rs.getInt(1));
        }
        conexao.close();

    }

    /**
     *
     * @param clinica
     * @throws SQLException
     */
    public void alterar(Clinica clinica) throws SQLException {
        
        
        conexao = new Conexao().conectar();
        String sql = "UPDATE clinica SET nome = ?, telefone = ?, contato = ? WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setString(1, clinica.getNome());
        pst.setString(2, clinica.getTelefone());
        pst.setString(3, clinica.getContato());
        
        pst.setInt(4, clinica.getId());

        pst.execute();

        conexao.close();
    }

    public void excluir(Clinica clinica) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "DELETE FROM clinica WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setInt(1, clinica.getId());

        pst.execute();

        conexao.close();
    }

    /**
     * Retorna o Clinica a partir do ID
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Clinica obter(int id) throws SQLException {
        Clinica clinica = null;
        
        conexao = new Conexao().conectar();

        String sql = "SELECT"
                    + "  nome,"
                    + "  telefone,"
                    + "  contato "
                    + "FROM"
                    + "  clinica "
                    + "WHERE"
                    + "  id = ?";
        
        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            clinica = new Clinica();
            
            clinica.setId(id);
            clinica.setNome(rs.getString("nome")); 
            clinica.setTelefone(rs.getString("telefone"));
            clinica.setContato(rs.getString("contato"));
        }

        conexao.close();

        return clinica;
    }
    
    public List<Clinica> obter() throws SQLException {
        List<Clinica> clinicas = new LinkedList<>();
        Clinica clinica;
        
        conexao = new Conexao().conectar();

        String sql = "SELECT"
                    + "  id,"
                    + "  nome,"
                    + "  telefone,"
                    + "  contato "
                    + "FROM"
                    + "  clinica "
                    + "ORDER BY "
                    + "  nome ";
        
        PreparedStatement pst = conexao.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            clinica = new Clinica();
            
            clinica.setId(rs.getInt("id"));
            clinica.setNome(rs.getString("nome")); 
            clinica.setTelefone(rs.getString("telefone"));
            clinica.setContato(rs.getString("contato"));
            clinicas.add(clinica);
        }

        conexao.close();

        return clinicas;
    }
}
