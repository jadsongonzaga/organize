package jadsongonzaga.organize.model;

import jadsongonzaga.organize.controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jadson
 */
public class AuditoriaDAO {

    Connection conexao;

    public void inserir(Auditoria auditoria) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "INSERT INTO auditoria (rotina, usuario_id, tipo_operacao, identificacao_registro) VALUES (?,?,?,?)";
        PreparedStatement pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setInt(1, auditoria.getRotina().getCodigo());
        pst.setInt(2, auditoria.getUsuario().getId());
        pst.setInt(3, auditoria.getTipoOperacao().getCodigo());
        pst.setInt(4, auditoria.getIdentificacaoRegistro());

        pst.execute();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            auditoria.setId(rs.getInt(1));
        }
        conexao.close();
    }
    
    public List<Auditoria> obter(LocalDate data) throws SQLException {
        List<Auditoria> auditorias = new LinkedList<>();
        Auditoria auditoria;
        
        conexao = new Conexao().conectar();

        String sql = "SELECT"
                    + "  id,"
                    + "  rotina,"
                    + "  usuario_id, "
                    + "  tipo_operacao, "
                    + "  identificacao_registro "
                    + "FROM"
                    + "  auditoria "
                    + "WHERE "
                    + "  to_char(data_criacao, 'yyyy-MM-dd') = ?"
                    + "ORDER BY "
                    + "  id ";
        
        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setString(1, data.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            auditoria = new Auditoria();
            
            auditoria.setId(rs.getInt("id"));
            auditoria.setIdentificacaoRegistro(rs.getInt("identificacao_registro"));
            auditoria.setRotina(Auditoria.Rotina.valueOfCodigo(rs.getInt("rotina")));
            auditoria.setTipoOperacao(Auditoria.TipoOperacao.valueOfCodigo(rs.getInt("tipo_operacao")));
            auditoria.setUsuario(new UsuarioDAO().obter(rs.getInt("usuario_id")));
            
            auditorias.add(auditoria);
        }

        conexao.close();

        return auditorias;
    }

}
