/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadsongonzaga.organize.model;

import jadsongonzaga.organize.controller.Conexao;
import jadsongonzaga.organize.controller.Utils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jadson
 */
public class PacienteDAO {
      Connection conexao;
     PessoaDAO pessoaDAO;

    public PacienteDAO() {
        pessoaDAO = new PessoaDAO();
    }
     
     

    /**
     *
     * @param paciente
     * @throws SQLException
     */
    public void inserir(Paciente paciente) throws SQLException {

        pessoaDAO.inserir(paciente.getPessoa());
        
        conexao = new Conexao().conectar();
        String sql = "INSERT INTO paciente (id, data_nacimento, escolaridade, estado_civil, quantidade_filho, conjuge, tipo_moradia, recebe_renda, observacao, acompanhante_id, tratamento_id, pessoa_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, paciente.getPessoa().getId());
        pst.setDate(2, Date.valueOf(paciente.getDataNacimento()));
        pst.setInt(3, paciente.getEscolaridade().getId());
        pst.setInt(4, paciente.getEstadoCivil().getId());
        pst.setInt(5, paciente.getQuatidadeFilho());
        pst.setString(6, paciente.getConjuge());
        pst.setInt(7, paciente.getTipoMoradia().getId());
        pst.setBoolean(8, paciente.isRecebeRenda());
        pst.setString(9, paciente.getObservacao());
        if(paciente.getAcompanhante() != null)
            pst.setInt(10, paciente.getAcompanhante().getPessoa().getId());
        else
            pst.setNull(10, 0);
        
        if(paciente.getTratamento() != null)
            pst.setInt(11, paciente.getTratamento().getId());
        else
            pst.setNull(11, 0);
        
        pst.setInt(12, paciente.getPessoa().getId());
        
        pst.execute();
        
        conexao.close();

    }
    
    /*

(
    id                      SERIAL NOT NULL,
    data_nacimento          DATE NOT NULL,
    escolaridade            INTEGER NOT NULL,
    estado_civil            INTEGER NULL,
    quantidade_filho        INTEGER DEFAULT 0 NOT NULL,
    conjuge                 VARCHAR(60) NULL,
    tipo_moradia            INTEGER DEFAULT 1 NOT NULL,
    recebe_renda            BOOL DEFAULT false NOT NULL,
    observacao              VARCHAR(100) NULL,
    acompanhante_id          INTEGER NULL,
    tratamento_id           INTEGER NULL,
    pessoa_id               INTEGER NOT NULL,
);
*/

    /**
     *
     * @param paciente
     * @throws SQLException
     */
    public void alterar(Paciente paciente) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "UPDATE paciente SET data_nacimento = ?, escolaridade = ?, estado_civil = ?, quantidade_filho = ?, conjuge = ?, tipo_moradia = ?, recebe_renda = ?, observacao = ?, acompanhante_id = ?, tratamento_id = ? WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        
        pst.setDate(1, Date.valueOf(paciente.getDataNacimento()));
        pst.setInt(2, paciente.getEscolaridade().getId());
        pst.setInt(3, paciente.getEstadoCivil().getId());
        pst.setInt(4, paciente.getQuatidadeFilho());
        pst.setString(5, paciente.getConjuge());
        pst.setInt(6, paciente.getTipoMoradia().getId());
        pst.setBoolean(7, paciente.isRecebeRenda());
        pst.setString(8, paciente.getObservacao());
        
        
        
        if(paciente.getAcompanhante() != null)
            pst.setInt(9, paciente.getAcompanhante().getPessoa().getId());
        else
            pst.setNull(9, 0);
        
        if(paciente.getTratamento() != null)
            pst.setInt(10, paciente.getTratamento().getId());
        else
            pst.setNull(10, 0);
        
        pst.setInt(11, paciente.getPessoa().getId());
        
        pst.execute();

        conexao.close();
        
        
        pessoaDAO.alterar(paciente.getPessoa());
        
    }

    public void excluir(Paciente paciente) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "DELETE FROM paciente WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);
        
        pst.setInt(1, paciente.getPessoa().getId());

        pst.execute();

        conexao.close();
        
        pessoaDAO.excluir(paciente.getPessoa());
    }

    /**
     * Retorna o bairro a partir do ID
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Paciente obter(int id) throws SQLException {
        Paciente paciente = null;
        conexao = new Conexao().conectar();
        String sql = "SELECT data_nacimento, escolaridade, estado_civil, quantidade_filho, conjuge, tipo_moradia, recebe_renda, observacao, acompanhante_id, tratamento_id, pessoa_id FROM paciente WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            paciente = new Paciente();
            paciente.setDataNacimento(Utils.paraLocalDate(rs.getDate("data_nacimento")));
            paciente.setEscolaridade(Paciente.Escolaridade.valueOfCodigo(rs.getInt("escolaridade")));
            paciente.setEstadoCivil(Paciente.EstadoCivil.valueOfCodigo(rs.getInt("estado_civil")));
            paciente.setQuatidadeFilho(rs.getInt("quantidade_filho"));
            paciente.setConjuge(rs.getString("conjuge"));
            paciente.setTipoMoradia(Paciente.TipoMoradia.valueOfCodigo(rs.getInt("tipo_moradia")));
            paciente.setRecebeRenda(rs.getBoolean("recebe_renda"));
            paciente.setObservacao(rs.getString("observacao"));
            paciente.setAcompanhante(new AcompanhanteDAO().obter(rs.getInt("acompanhante_id")));
            //paciente.setTratamento(new AcompanhanteDAO().obter(rs.getInt("acompanhante_id")));
            System.out.println("FALTAMENTO TRATAMENTO");
            paciente.setPessoa(pessoaDAO.obter(id));
        }

        conexao.close();

        return paciente;
    }
    
    public List<Paciente> obter() throws SQLException {
        List<Paciente> pacientes = new ArrayList<>();
        Paciente paciente;
        conexao = new Conexao().conectar();
        String sql = "SELECT * FROM paciente";
        PreparedStatement pst = conexao.prepareStatement(sql);
        
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            paciente = new Paciente();
            paciente.setDataNacimento(Utils.paraLocalDate(rs.getDate("data_nacimento")));
            paciente.setEscolaridade(Paciente.Escolaridade.valueOfCodigo(rs.getInt("escolaridade")));
            paciente.setEstadoCivil(Paciente.EstadoCivil.valueOfCodigo(rs.getInt("estado_civil")));
            paciente.setQuatidadeFilho(rs.getInt("quantidade_filho"));
            paciente.setConjuge(rs.getString("conjuge"));
            paciente.setTipoMoradia(Paciente.TipoMoradia.valueOfCodigo(rs.getInt("tipo_moradia")));
            paciente.setRecebeRenda(rs.getBoolean("recebe_renda"));
            paciente.setObservacao(rs.getString("observacao"));
            paciente.setAcompanhante(new AcompanhanteDAO().obter(rs.getInt("acompanhante_id")));
            //paciente.setTratamento(new AcompanhanteDAO().obter(rs.getInt("acompanhante_id")));
            System.out.println("FALTAMENTO TRATAMENTO");
            paciente.setPessoa(pessoaDAO.obter(rs.getInt("pessoa_id")));
        }

        conexao.close();

        return pacientes;
    }
    
}
