
package jadsongonzaga.organize.model;

import jadsongonzaga.organize.controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jadson
 */
public class EstadoDAO {
    
      
    Connection conexao;
    
    public Estado obter(int id) throws SQLException{
        Estado estado = null;
        conexao = new Conexao().conectar();
        String sql = "SELECT nome FROM estado WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            estado = new Estado();
            estado.setId(id);
            estado.setNome(rs.getString("nome"));
        }
        
        return estado;
    }
    
    
    public List<Estado> obter() throws SQLException{
        
        List<Estado> estados = new ArrayList<>();
        Estado estado;
        conexao = new Conexao().conectar();
        String sql = "SELECT id, nome FROM estado";
        PreparedStatement pst = conexao.prepareStatement(sql);
        
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            estado = new Estado();
            estado.setId(rs.getInt("id"));
            estado.setNome(rs.getString("nome"));
            estados.add(estado);
        }

        return estados;
    }
    
}
