
package jadsongonzaga.organize.model;

import jadsongonzaga.organize.controller.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jadson
 */
public class ServicoDAO {
    
    Connection conexao;
 
    /**
     * Persiste uma Servico, atualiza o ID da referencia
     *
     * @param servico
     * @throws SQLException
     */
    public void inserir(Servico servico) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "INSERT INTO servico (descricao, paciente_id) VALUES (?, ?)";
        PreparedStatement pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        pst.setString(1, servico.getDescricao());
        pst.setInt(2, servico.getPaciente().getPessoa().getId());
        
        servico.setSituacao(Situacao.ABERTO);
        
        pst.execute();
        ResultSet rs = pst.getGeneratedKeys();
        
        if (rs.next()) {
            int id = rs.getInt(1);
            Servico ser = obter(id);
            servico.setId(id);
            servico.setDataHoraCriacao(ser.getDataHoraCriacao());
        }
        
        conexao.close();

    }

    /**
     *
     * @param servico
     * @throws SQLException
     */
    public void alterar(Servico servico) throws SQLException {

        conexao = new Conexao().conectar();
        String sql = "UPDATE servico SET descricao = ?, paciente_id = ?, situacao = ? WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setString(1, servico.getDescricao());
        pst.setInt(2, servico.getPaciente().getPessoa().getId());
        pst.setInt(3, servico.getSituacao().getId());

        pst.setInt(4, servico.getId());

        pst.execute();

        conexao.close();
    }

    public void excluir(Servico servico) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "DELETE FROM servico WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setInt(1, servico.getId());

        pst.execute();

        conexao.close();
    }

    /**
     * Retorna o Servico a partir do ID
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Servico obter(int id) throws SQLException {
        Servico servico = null;
        
        conexao = new Conexao().conectar();
        
        String sql =  "SELECT"
                    + "  descricao, "
                    + "  paciente_id,"
                    + "  situacao,"
                    + "  replace(to_char(data_criacao, 'yyyy-MM-dd T HH:mm:ss'), ' ','') as data_criacao "
                    + "FROM"
                    + "  servico "
                    + "WHERE"
                    + "  id = ?";
        
        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            servico = new Servico();
            
            servico.setId(id);
            servico.setDescricao(rs.getString("descricao")); 
            servico.setPaciente(new PacienteDAO().obter(rs.getInt("paciente_id"))); 
            servico.setSituacao(Situacao.valueOfId(rs.getInt("situacao")));
            servico.setDataHoraCriacao(LocalDateTime.parse(rs.getString("data_criacao")));
            
        }

        conexao.close();

        return servico;
    }
    
    public List<Servico> obter() throws SQLException {
        List<Servico> servicos = new LinkedList<>();
        Servico servico;
        
        conexao = new Conexao().conectar();
        
        String sql =  "SELECT"
                    + "  id,"
                    + "  descricao,"
                    + "  paciente_id,"
                    + "  situacao,"
                    + "  data_criacao "
                    + "FROM"
                    + "  servico "
                    + "WHERE"
                    + "  id = ?";
        
        PreparedStatement pst = conexao.prepareStatement(sql);
        
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            servico = new Servico();
            
            servico.setId(rs.getInt("id"));
            servico.setDescricao(rs.getString("descricao")); 
            servico.setPaciente(new PacienteDAO().obter(rs.getInt("paciente_id"))); 
            servico.setSituacao(Situacao.valueOfId(rs.getInt("situacao")));
            
            servicos.add(servico);

        }

        conexao.close();

        return servicos;
    }
}
