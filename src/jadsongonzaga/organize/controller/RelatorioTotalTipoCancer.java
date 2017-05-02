package jadsongonzaga.organize.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author jadson
 */
public class RelatorioTotalTipoCancer {

    public JasperPrint gerar() {
        JasperPrint rel = null;
        Connection con = new Conexao().conectar();
        Map<String, Object> map = new HashMap();

        String arquivoJasper = "./report/pacienteTipoCancer.jasper";
        try {
            rel = JasperFillManager.fillReport(arquivoJasper, map, con);

            con.close();
        } catch (SQLException | JRException ex) {
            ExceptionController.tratar(ex);
        }
        
        return rel;
    }
}
