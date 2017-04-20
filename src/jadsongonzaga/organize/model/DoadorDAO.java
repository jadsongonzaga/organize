
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
public class DoadorDAO {
    
    Connection conexao;
 
    /**
     * Persiste uma Doador, atualiza o ID da referencia
     *
     * @param doador
     * @throws SQLException
     */
    public void inserir(Doador doador) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "INSERT INTO doador (nome, endereco, telefone, cpf, municipio_id) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, doador.getNome());
        pst.setString(2, doador.getEndereco());
        pst.setString(3, doador.getTelefone());
        pst.setString(4, doador.getCpf());
        pst.setInt(5, doador.getMunicipio().getId());
        
        pst.execute();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            doador.setId(rs.getInt(1));
        }
        conexao.close();

    }

    /**
     *
     * @param doador
     * @throws SQLException
     */
    public void alterar(Doador doador) throws SQLException {
        
        
        conexao = new Conexao().conectar();
        String sql = "UPDATE doador SET nome = ?, endereco = ?, telefone = ?, cpf = ?, municipio_id = ? WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setString(1, doador.getNome());
        pst.setString(2, doador.getEndereco());
        pst.setString(3, doador.getTelefone());
        pst.setString(4, doador.getCpf());
        pst.setInt(5, doador.getMunicipio().getId());
        
        pst.setInt(6, doador.getId());

        pst.execute();

        conexao.close();
    }

    public void excluir(Doador doador) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "DELETE FROM doador WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setInt(1, doador.getId());

        pst.execute();

        conexao.close();
    }

    /**
     * Retorna o Doador a partir do ID
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Doador obter(int id) throws SQLException {
        Doador doador = null;
        
        conexao = new Conexao().conectar();

        String sql = "SELECT"
                    + "  nome,"
                    + "  endereco,"
                    + "  telefone,"
                    + "  cpf,"
                    + "  municipio_id "
                    + "FROM"
                    + "  doador "
                    + "WHERE"
                    + "  id = ?";
        
        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            doador = new Doador();
            
            doador.setId(id);
            doador.setNome(rs.getString("nome"));
            doador.setEndereco(rs.getString("endereco"));
            doador.setTelefone(rs.getString("telefone"));
            doador.setCpf(rs.getString("cpf"));
            doador.setMunicipio(new MunicipioDAO().obter(rs.getInt("municipio_id")));
        }

        conexao.close();

        return doador;
    }
    
    public List<Doador> obter() throws SQLException {
        List<Doador> doadores = new LinkedList<>();
        Doador doador;
        
        conexao = new Conexao().conectar();

        String sql = "SELECT"
                    + "  nome,"
                    + "  endereco,"
                    + "  telefone,"
                    + "  cpf,"
                    + "  municipio_id "
                    + "FROM"
                    + "  doador "
                    + "ORDER BY"
                    + "  id";
        
        PreparedStatement pst = conexao.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            doador = new Doador();
            
            doador.setId(rs.getInt("id"));
            doador.setNome(rs.getString("nome"));
            doador.setEndereco(rs.getString("endereco"));
            doador.setTelefone(rs.getString("telefone"));
            doador.setCpf(rs.getString("cpf"));
            doador.setMunicipio(new MunicipioDAO().obter(rs.getInt("municipio_id")));
            doadores.add(doador);
        }

        conexao.close();

        return doadores;
    }
}