
package jadsongonzaga.organize.model;

import jadsongonzaga.organize.controller.Conexao;
import jadsongonzaga.organize.controller.Utils;
import java.sql.Connection;
import java.sql.Date;
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
public class TratamentoDAO {
    
    Connection conexao;
 
    /**
     * Persiste uma Tratamento, atualiza o ID da referencia
     *
     * @param tratamento
     * @throws SQLException
     */
    public void inserir(Tratamento tratamento) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "INSERT INTO tratamento (quimioterapio, radioterapio, data_diagnostico, data_fim_tratamento, tipo_finalizacao, tipo_cancer_id, clinica_id, paciente_id) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setBoolean(1, tratamento.isQuimioterapio());
        pst.setBoolean(2, tratamento.isRadioterapio());
        pst.setDate(3, tratamento.getDataDiagnostico() == null ? null : Date.valueOf(tratamento.getDataDiagnostico()));
        pst.setDate(4, tratamento.getDataFimTratamento() == null ? null : Date.valueOf(tratamento.getDataFimTratamento()));
        if(tratamento.getTipoFim() == null)
            pst.setNull(5, 0);
        else
            pst.setInt(5, tratamento.getTipoFim().getId());
        
        pst.setInt(6, tratamento.getTipoCancer().getId());
        
        if(tratamento.getClinica() == null)
            pst.setNull(7, 0);
        else
            pst.setInt(7, tratamento.getClinica().getId());
        if(tratamento.getPaciente() == null)
            pst.setNull(8, 0);
        else
            pst.setInt(8, tratamento.getPaciente().getId());
        
        pst.execute();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            tratamento.setId(rs.getInt(1));
        }
        conexao.close();

    }

    /**
     *
     * @param tratamento
     * @throws SQLException
     */
    public void alterar(Tratamento tratamento) throws SQLException {
        
        
        conexao = new Conexao().conectar();
        String sql = "UPDATE tratamento SET quimioterapio = ?, radioterapio = ?, data_diagnostico = ?, data_fim_tratamento = ?, tipo_finalizacao = ?, tipo_cancer_id = ?, clinica_id = ?, paciente_id = ?, data_criacao = ? WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setBoolean(1, tratamento.isQuimioterapio());
        pst.setBoolean(2, tratamento.isRadioterapio());
        pst.setDate(3, Date.valueOf(tratamento.getDataDiagnostico()));
        pst.setDate(4, Date.valueOf(tratamento.getDataFimTratamento()));
        pst.setInt(5, tratamento.getTipoFim().getId());
        pst.setInt(6, tratamento.getTipoCancer().getId());
        pst.setInt(7, tratamento.getClinica().getId());
        pst.setInt(8, tratamento.getPaciente().getId());
        
        pst.setInt(9, tratamento.getId());

        pst.execute();

        conexao.close();
    }

    public void excluir(Tratamento tratamento) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "DELETE FROM tratamento WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setInt(1, tratamento.getId());

        pst.execute();

        conexao.close();
    }

    /**
     * Retorna o Tratamento a partir do ID
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Tratamento obter(int id) throws SQLException {
        Tratamento tratamento = null;
        
        conexao = new Conexao().conectar();

        String sql =  "SELECT"
                    + "  quimioterapio," 
                    + "  radioterapio," 
                    + "  data_diagnostico," 
                    + "  data_fim_tratamento," 
                    + "  tipo_finalizacao,"
                    + "  tipo_cancer_id,"
                    + "  clinica_id,"
                    + "  paciente_id "
                    + "FROM"
                    + "  tratamento "
                    + "WHERE"
                    + "  id = ?";
        
        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            tratamento = new Tratamento();
            
            tratamento.setId(id);
            tratamento.setQuimioterapio(rs.getBoolean("quimioterapio"));
            tratamento.setRadioterapio(rs.getBoolean("radioterapio"));
            tratamento.setDataDiagnostico(Utils.paraLocalDate(rs.getDate("data_diagnostico")));
            tratamento.setDataFimTratamento(Utils.paraLocalDate(rs.getDate("data_fim_tratamento")));
            tratamento.setTipoFim(Tratamento.TipoFim.valueOfId(rs.getInt("tipo_finalizacao")));
            tratamento.setTipoCancer(new TipoCancerDAO().obter(rs.getInt("tipo_cancer_id")));
            tratamento.setClinica(new ClinicaDAO().obter(rs.getInt("clinica_id")));
            tratamento.setPaciente(new PacienteDAO().obter(rs.getInt("clinica_id")));
        }

        conexao.close();

        return tratamento;
    }
    
    public List<Tratamento> obter() throws SQLException {
        List<Tratamento> tratamentos = new LinkedList<>();
        Tratamento tratamento;
        
        conexao = new Conexao().conectar();

        String sql =  "SELECT"
                    + "  id,"
                    + "  quimioterapio,"
                    + "  radioterapio," 
                    + "  data_diagnostico," 
                    + "  data_fim_tratamento," 
                    + "  tipo_finalizacao,"
                    + "  tipo_cancer_id,"
                    + "  clinica_id,"
                    + "  paciente_id "
                    + "FROM"
                    + "  tratamento "
                    + "WHERE"
                    + "  id = ?";
        
        
        PreparedStatement pst = conexao.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            tratamento = new Tratamento();
            
            tratamento.setId(rs.getInt("id"));
            tratamento.setQuimioterapio(rs.getBoolean("quimioterapio"));
            tratamento.setRadioterapio(rs.getBoolean("radioterapio"));
            tratamento.setDataDiagnostico(Utils.paraLocalDate(rs.getDate("data_diagnostico")));
            tratamento.setDataFimTratamento(Utils.paraLocalDate(rs.getDate("data_fim_tratamento")));
            tratamento.setTipoFim(Tratamento.TipoFim.valueOfId(rs.getInt("tipo_finalizacao")));
            tratamento.setTipoCancer(new TipoCancerDAO().obter(rs.getInt("tipo_cancer_id")));
            tratamento.setClinica(new ClinicaDAO().obter(rs.getInt("clinica_id")));
            tratamento.setPaciente(new PacienteDAO().obter(rs.getInt("clinica_id")));

            tratamentos.add(tratamento);
        }

        conexao.close();

        return tratamentos;
    }
}
