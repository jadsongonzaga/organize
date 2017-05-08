
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
public class LoginDAO {
    
    Connection conexao;

    public void inserir(Login login) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "INSERT INTO login (usuario_id) VALUES (?)";
        PreparedStatement pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        pst.setInt(1, login.getUsuario().getId());

        pst.execute();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            login.setId(rs.getInt(1));
        }
        conexao.close();
    }
  
}
