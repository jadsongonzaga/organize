
package jadsongonzaga.organize.view;

import jadsongonzaga.organize.controller.AuditoriaController;
import jadsongonzaga.organize.model.Auditoria;
import java.time.LocalDate;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jadson
 */
public class AuditoriaTableModel extends AbstractTableModel {
    
    String [] colunas;

    List<Auditoria> dados;
    
    public AuditoriaTableModel(LocalDate data) {
        dados = new AuditoriaController().obter(data);
        colunas = new String[] {"Identificador","Rotina", "Tipo de operação", "Identificador do registro", "Usuário"};
    }
    
   

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    
    @Override
    public int getRowCount() {
        
        return (dados == null) ? 0 : dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(dados != null){
            switch(columnIndex){
                case 0:
                    return dados.get(rowIndex).getId();
                case 1:
                    return dados.get(rowIndex).getRotina();
                case 2:
                    return dados.get(rowIndex).getTipoOperacao();
                case 3:
                    return dados.get(rowIndex).getIdentificacaoRegistro();
                case 4:
                    return dados.get(rowIndex).getUsuario();
            }
        }
        
       return null;
    }

}