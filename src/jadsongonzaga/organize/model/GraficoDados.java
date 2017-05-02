
package jadsongonzaga.organize.model;

import jadsongonzaga.organize.controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jfree.data.general.DefaultKeyedValuesDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author jadson
 */
public class GraficoDados {
    
    Connection conexao;
    
    public DefaultPieDataset obterTotalTipoCancer() throws SQLException {
        
        DefaultPieDataset pieData = new DefaultKeyedValuesDataset();
        String sql;

        sql =   "SELECT" +
                "   count(tra.paciente_id) quantidade_paciente," +
                "   tca.descricao " +
                "FROM " +
                "   tratamento tra " +
                "   INNER JOIN tipo_cancer tca on tra.tipo_cancer_id = tca.id " +
                "WHERE" +
                "   tra.tipo_finalizacao isnull and" +
                "   tra.data_fim_tratamento is null " +
                "GROUP BY" +
                "   tca.descricao";
        conexao = new Conexao().conectar();
        PreparedStatement pst = conexao.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            pieData.setValue(rs.getString("descricao"), rs.getInt("quantidade_paciente"));
        }

        return pieData;

    }
}
