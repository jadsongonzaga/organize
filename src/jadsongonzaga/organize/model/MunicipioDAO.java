

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
public class MunicipioDAO {
    
    
      
    Connection conexao;
    
    public Municipio obter(int id) throws SQLException{
        Municipio municipio = null;
        conexao = new Conexao().conectar();
        String sql = "SELECT nome, estado_id FROM municipio WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            municipio = new Municipio();
            municipio.setId(id);
            municipio.setNome(rs.getString("nome"));
            municipio.setEstado(new EstadoDAO().obter(rs.getInt("estado_id")));
        }
        
        return municipio;
    }
    
    
    public List<Municipio> obter() throws SQLException{
        
        List<Municipio> municipios = new ArrayList<>();
        Municipio municipio;
        conexao = new Conexao().conectar();
        String sql = "SELECT id, nome, estado_id FROM municipio";
        PreparedStatement pst = conexao.prepareStatement(sql);
        
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            municipio = new Municipio();
            municipio.setId(rs.getInt("id"));
            municipio.setNome(rs.getString("nome"));
            municipios.add(municipio);
        }

        return municipios;
    }
    
    
    
}
