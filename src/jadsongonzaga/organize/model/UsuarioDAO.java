
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
public class UsuarioDAO {
    
    Connection conexao;
 
    /**
     * Persiste uma Usuario, atualiza o ID da referencia
     *
     * @param usuario
     * @throws SQLException
     */
    public void inserir(Usuario usuario) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "INSERT INTO usuario (nome, login, senha, tipo) VALUES (?,?,?,?)";
        PreparedStatement pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, usuario.getNome());
        pst.setString(2, usuario.getLogin());
        pst.setString(3, usuario.getSenha());
        pst.setInt(4, usuario.getTipo().getId());
        
        pst.execute();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            usuario.setId(rs.getInt(1));
        }
        conexao.close();

    }

    /**
     *
     * @param usuario
     * @throws SQLException
     */
    public void alterar(Usuario usuario) throws SQLException {
        
        
        conexao = new Conexao().conectar();
        String sql = "UPDATE usuario SET nome = ?, login = ?, senha = ?, tipo = ? WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setString(1, usuario.getNome());
        pst.setString(2, usuario.getLogin());
        pst.setString(3, usuario.getSenha());
        pst.setInt(4, usuario.getTipo().getId());
        
        pst.setInt(5, usuario.getId());

        pst.execute();

        conexao.close();
    }

    public void excluir(Usuario usuario) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "DELETE FROM usuario WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setInt(1, usuario.getId());

        pst.execute();

        conexao.close();
    }

    /**
     * Retorna o Usuario a partir do ID
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Usuario obter(int id) throws SQLException {
        Usuario usuario = null;
        
        conexao = new Conexao().conectar();

        String sql = "SELECT"
                    + "  nome,"
                    + "  login,"
                    + "  senha,"
                    + "  tipo "
                    + "FROM"
                    + "  usuario "
                    + "WHERE"
                    + "  id = ?";
        
        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            usuario = new Usuario();
            
            usuario.setId(id);
            usuario.setLogin(rs.getString("login")); 
            usuario.setNome(rs.getString("nome")); 
            usuario.setSenha(rs.getString("senha")); 
            usuario.setTipo(Usuario.Tipo.valueOfId(rs.getInt("tipo"))); 
        }

        conexao.close();

        return usuario;
    }
    
    public Usuario obter(String login) throws SQLException {
        Usuario usuario = null;
        
        conexao = new Conexao().conectar();

        String sql = "SELECT"
                    + "  id,"
                    + "  nome,"
                    + "  login,"
                    + "  senha,"
                    + "  tipo "
                    + "FROM"
                    + "  usuario "
                    + "WHERE"
                    + "  login = ?";
        
        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setString(1, login);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            usuario = new Usuario();
            
            usuario.setId(rs.getInt("id"));
            usuario.setLogin(rs.getString("login")); 
            usuario.setNome(rs.getString("nome")); 
            usuario.setSenha(rs.getString("senha")); 
            usuario.setTipo(Usuario.Tipo.valueOfId(rs.getInt("tipo"))); 
        }

        conexao.close();

        return usuario;
    }
    
    public List<Usuario> obter() throws SQLException {
        List<Usuario> usuarios = new LinkedList<>();
        Usuario usuario;
 
        conexao = new Conexao().conectar();

        String sql = "SELECT"
                    + "  id,"
                    + "  nome,"
                    + "  login,"
                    + "  senha, "
                    + "  tipo "
                    + "FROM"
                    + "  usuario ";

        PreparedStatement pst = conexao.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            usuario = new Usuario();

            usuario.setId(rs.getInt("id"));
            usuario.setLogin(rs.getString("login")); 
            usuario.setNome(rs.getString("nome")); 
            usuario.setSenha(rs.getString("senha")); 
            usuario.setTipo(Usuario.Tipo.valueOfId(rs.getInt("tipo"))); 

            usuarios.add(usuario);
        }

        conexao.close();

        return usuarios;
    }
}
