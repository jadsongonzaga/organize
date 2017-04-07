
package jadsongonzaga.organize.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author jadson
 */
public class Utils {
    public static String removeFormatacao(String valor){
        valor = valor.replace("-", "");
        valor = valor.replace(" ", "");
        valor = valor.replace(".", "");
        valor = valor.replace("(", "");
        valor = valor.replace(")", "");
        
        return valor;
    }
    
    public static double paraDouble(String valor){
        valor = valor.replace(".", "");
        valor = valor.replace(",", ".");
        
        //1.200,0
        //
        return Double.parseDouble(valor);
    }
    
    public static LocalDate paraLocalDate(Date data){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        return LocalDate.parse(sdf.format(data));
    }
    
    /**
     * Formatar um valor em #,##0.00
     * @param valor
     * @return 
     */
    public static String paraString(double valor){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        
        return df.format(valor);
    }
    
    public static String capitalize(String texto){
        
        
        return texto.substring(0, 1).toUpperCase() + texto.substring(1);
    }
    
}
