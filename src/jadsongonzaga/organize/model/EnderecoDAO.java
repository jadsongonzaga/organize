package jadsongonzaga.organize.model;

import jadsongonzaga.organize.controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jadson
 */
public class EnderecoDAO {

    Connection conexao;

    /**
     * Persiste um Endereço, atualiza o ID da referencia
     *
     * @param endereco
     * @throws SQLException
     */
    public void inserir(Endereco endereco) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "INSERT INTO endereco (cep, logradouro, numero, ponto_referencia, municipio_id, bairro) VALUES (?,?,?,?,?,?)";
        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setString(1, endereco.getCep());
        pst.setString(2, endereco.getLogradouro());
        pst.setString(3, endereco.getNumero());
        pst.setString(4, endereco.getPontoReferencia());
        pst.setInt(5, endereco.getMunicipio().getId());
        pst.setString(6, endereco.getBairro());
        pst.execute();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            endereco.setId(rs.getInt(1));
        }
        conexao.close();

    }

    /**
     *
     * @param endereco
     * @throws SQLException
     */
    public void alterar(Endereco endereco) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "UPDATE endereco SET cep = ?, logradouro = ?, numero = ?, ponto_referencia = ?, municipio_id = ?, bairro = ? WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setString(1, endereco.getCep());
        pst.setString(2, endereco.getLogradouro());
        pst.setString(3, endereco.getNumero());
        pst.setString(4, endereco.getPontoReferencia());
        pst.setInt(5, endereco.getMunicipio().getId());
        pst.setString(6, endereco.getBairro());
        pst.setInt(7, endereco.getId());

        pst.execute();

        conexao.close();
    }

    public void excluir(Endereco endereco) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "DELETE FROM endereco WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);
        
        pst.setInt(1, endereco.getId());

        pst.execute();

        conexao.close();
    }

    /**
     * Retorna o bairro a partir do ID
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Endereco obter(int id) throws SQLException {
        Endereco endereco = null;
        conexao = new Conexao().conectar();
        String sql = "SELECT cep, logradouro, numero, ponto_referencia, municipio_id, bairro FROM endereco WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            endereco = new Endereco();
            endereco.setId(id);
            endereco.setCep(rs.getString("cep"));
            endereco.setLogradouro(rs.getString("logradouro"));
            endereco.setNumero(rs.getString("numero"));
            endereco.setPontoReferencia(rs.getString("ponto_referencia"));
            endereco.setMunicipio(new MunicipioDAO().obter(rs.getInt("municipio_id")));
            endereco.setBairro(rs.getString("bairro"));
        }

        conexao.close();

        return endereco;
    }

}
