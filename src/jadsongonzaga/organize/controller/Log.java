
package jadsongonzaga.organize.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jadson
 */
public class Log {
    
    private static final String DIRETORIO = "log/log.txt";
    
    public static void gravar(String texto){
        
        FileWriter write = null;
        try {
            File file = new File(DIRETORIO);
            write = new FileWriter(file, true);
            
            texto = "## " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + "\n" + texto+"\n\n";
            
            write.write(texto);
        } catch (IOException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                write.close();
            } catch (IOException ex) {
                Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
}
