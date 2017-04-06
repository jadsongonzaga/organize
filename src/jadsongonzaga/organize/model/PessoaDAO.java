/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class PessoaDAO {

    Connection conexao;
    EnderecoDAO enderecoDAO;

    public PessoaDAO() {
        enderecoDAO = new EnderecoDAO();
    }
    
    
    /**
     * Persiste um Pessoa, atualiza o ID da referencia
     *
     * @param pessoa
     * @throws SQLException
     */
    public void inserir(Pessoa pessoa) throws SQLException {
        enderecoDAO.inserir(pessoa.getEndereco());
        conexao = new Conexao().conectar();
        String sql = "INSERT INTO pessoa (nome, rg, profissao, telefone, celular, email, endereco_id) VALUES (?,?,?,?,?,?,?)";       
        PreparedStatement pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, pessoa.getNome());
        pst.setString(2, pessoa.getRg());
        pst.setString(3, pessoa.getProfissao());
        pst.setString(4, pessoa.getTelefone());
        pst.setString(5, pessoa.getCelular());
        pst.setString(6, pessoa.getEmail());
        pst.setInt(7, pessoa.getEndereco().getId());

        pst.execute();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            pessoa.setId(rs.getInt(1));
        }
        conexao.close();

    }

    /**
     *
     * @param pessoa
     * @throws SQLException
     */
    public void alterar(Pessoa pessoa) throws SQLException {
        
        enderecoDAO.alterar(pessoa.getEndereco());
        conexao = new Conexao().conectar();
        String sql = "UPDATE pessoa SET nome = ?, rg = ?, profissao = ?, telefone = ?, celular = ?, email = ?, endereco_id = ? WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setString(1, pessoa.getNome());
        pst.setString(2, pessoa.getRg());
        pst.setString(3, pessoa.getProfissao());
        pst.setString(4, pessoa.getTelefone());
        pst.setString(5, pessoa.getCelular());
        pst.setString(6, pessoa.getEmail());
        pst.setInt(7, pessoa.getEndereco().getId());
        pst.setInt(8, pessoa.getId());

        pst.execute();

        conexao.close();
    }

    public void excluir(Pessoa pessoa) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "DELETE FROM pessoa WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setInt(1, pessoa.getId());

        pst.execute();

        conexao.close();
        
        enderecoDAO.excluir(pessoa.getEndereco());
    }

    /**
     * Retorna o bairro a partir do ID
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Pessoa obter(int id) throws SQLException {
        Pessoa pessoa = null;
        Municipio municipio = null;
        Estado estado = null;
        Endereco endereco;
        conexao = new Conexao().conectar();

        String sql = "SELECT"
                    + "  pes.nome,"
                    + "  pes.rg,"
                    + "  pes.profissao,"
                    + "  pes.telefone,"
                    + "  pes.celular,"
                    + "  pes.email,"
                    + "  pes.endereco_id,"
                    + "  en.cep,"
                    + "  en.logradouro,"
                    + "  en.numero,"
                    + "  en.ponto_referencia,"
                    + "  en.municipio_id,"
                    + "  en.bairro,"
                    + "  mun.nome as nome_municipio,"
                    + "  mun.estado_id,"
                    + "  est.nome as nome_estado "
                    + "FROM"
                    + "  pessoa pes"
                    + "  INNER JOIN endereco en ON pes.endereco_id = en.id"
                    + "  INNER JOIN municipio mun ON en.municipio_id = mun.id"
                    + "  INNER JOIN estado est ON mun.estado_id = est.id "
                    + "WHERE"
                    + "  pes.id = ?";
        
        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            pessoa = new Pessoa();
            endereco = new Endereco();
            estado = new Estado();
            municipio = new Municipio();
            
            estado.setId(rs.getInt("estado_id"));
            estado.setNome(rs.getString("nome_estado"));
            
            municipio.setId(rs.getInt("municipio_id"));
            municipio.setNome(rs.getString("nome_municipio"));
            municipio.setEstado(estado);
            
            endereco.setId(rs.getInt("endereco_id"));
            endereco.setCep(rs.getString("cep"));
            endereco.setLogradouro(rs.getString("logradouro"));
            endereco.setNumero(rs.getString("numero"));
            endereco.setPontoReferencia(rs.getString("ponto_referencia"));
            endereco.setMunicipio(municipio);
            endereco.setBairro(rs.getString("bairro"));
            
            pessoa.setId(id);
            pessoa.setCelular(rs.getString("celular"));
            pessoa.setEmail(rs.getString("email"));
            pessoa.setNome(rs.getString("nome"));
            pessoa.setProfissao(rs.getString("profissao"));
            pessoa.setRg(rs.getString("rg"));
            pessoa.setTelefone(rs.getString("telefone"));
            
            
        }

        conexao.close();

        return pessoa;
    }
}
