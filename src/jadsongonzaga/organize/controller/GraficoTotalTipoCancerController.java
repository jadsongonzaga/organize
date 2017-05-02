
package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.GraficoDados;
import java.awt.Font;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author jadson
 */
public class GraficoTotalTipoCancerController {
    
    private GraficoDados dados;
    
    public ChartPanel gerar(){
        
        dados = new GraficoDados();
        
        DefaultPieDataset data = null;
        try {
            data = dados.obterTotalTipoCancer();
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }
        
        JFreeChart chart = ChartFactory.createPieChart3D("", data, true, true, true);
        
          
        
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        
        
        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
            "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        plot.setLabelGenerator(gen);
        
        
        
        ChartPanel chartPanel = new ChartPanel(chart);
        
        return chartPanel;
    }
    
}
