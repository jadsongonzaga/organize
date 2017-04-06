
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
public class AcompanhanteDAO {
     Connection conexao;
     PessoaDAO pessoaDAO;

    public AcompanhanteDAO() {
        pessoaDAO = new PessoaDAO();
    }
     
     

    /**
     *
     * @param acompanhante
     * @throws SQLException
     */
    public void inserir(Acompanhante acompanhante) throws SQLException {

        pessoaDAO.inserir(acompanhante.getPessoa());
        
        conexao = new Conexao().conectar();
        String sql = "INSERT INTO acompanhante (id, grau_parentesco) VALUES (?,?)";
        PreparedStatement pst = conexao.prepareStatement(sql);
        
        pst.setInt(1, acompanhante.getPessoa().getId());
        pst.setInt(2, acompanhante.getGrauParentesco().getCodigo());
        
        pst.execute();
        
        conexao.close();

    }

    /**
     *
     * @param acompanhante
     * @throws SQLException
     */
    public void alterar(Acompanhante acompanhante) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "UPDATE acompanhante SET grau_parentesco = ? WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);

        pst.setInt(1, acompanhante.getGrauParentesco().getCodigo());
        pst.setInt(1, acompanhante.getPessoa().getId());

        pst.execute();

        conexao.close();
        
        
        pessoaDAO.alterar(acompanhante.getPessoa());
        
    }

    public void excluir(Acompanhante acompanhante) throws SQLException {
        conexao = new Conexao().conectar();
        String sql = "DELETE FROM acompanhante WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);
        
        pst.setInt(1, acompanhante.getPessoa().getId());

        pst.execute();

        conexao.close();
        
        pessoaDAO.excluir(acompanhante.getPessoa());
    }

    /**
     * Retorna o bairro a partir do ID
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Acompanhante obter(int id) throws SQLException {
        Acompanhante acompanhante = null;
        conexao = new Conexao().conectar();
        String sql = "SELECT grau_parentesco FROM acompanhante WHERE id = ?";
        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            acompanhante = new Acompanhante();
            acompanhante.setGrauParentesco(Acompanhante.GrauParentesco.valueOfCodigo(rs.getInt("grau_parentesco")));
            acompanhante.setPessoa(pessoaDAO.obter(id));
        }

        conexao.close();

        return acompanhante;
    }
    
    public List<Acompanhante> obter() throws SQLException {
        List<Acompanhante> acompanhantes = new ArrayList<>();
        Acompanhante acompanhante;
        conexao = new Conexao().conectar();
        String sql = "SELECT id, grau_parentesco FROM acompanhante";
        PreparedStatement pst = conexao.prepareStatement(sql);
        
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            acompanhante = new Acompanhante();
            acompanhante.setGrauParentesco(Acompanhante.GrauParentesco.valueOfCodigo(rs.getInt("grau_parentesco")));
            acompanhante.setPessoa(pessoaDAO.obter(rs.getInt("id")));
            acompanhantes.add(acompanhante);
        }

        conexao.close();

        return acompanhantes;
    }
    
}
