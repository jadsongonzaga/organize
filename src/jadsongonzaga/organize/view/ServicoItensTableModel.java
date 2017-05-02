
package jadsongonzaga.organize.view;

import jadsongonzaga.organize.controller.ServicoItemController;
import jadsongonzaga.organize.model.Servico;
import jadsongonzaga.organize.model.ServicoItem;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jadson
 */
public class ServicoItensTableModel extends AbstractTableModel {

    
    String [] colunas;

    List<ServicoItem> dados;
    
    public ServicoItensTableModel(Servico servico) {
        if(servico != null)
            dados = new ServicoItemController().obter(servico);
        colunas = new String[] {"  ","Tipo do serviço", "Quantidade"};
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
                    return rowIndex + 1;
                case 1:
                    return dados.get(rowIndex).getTipoServico();
                case 2:
                    return new DecimalFormat("#,##0.00").format(dados.get(rowIndex).getQuantidade());

            }
        }
        
       return null;
    }

}
