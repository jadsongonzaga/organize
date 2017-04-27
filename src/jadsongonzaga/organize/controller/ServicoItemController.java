
package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Auditoria;
import jadsongonzaga.organize.model.Servico;
import jadsongonzaga.organize.model.ServicoItem;
import jadsongonzaga.organize.model.ServicoItemDAO;
import jadsongonzaga.organize.model.TipoServico;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jadson
 */
public class ServicoItemController {
    
    private final ServicoItemDAO dao;
    private final AuditoriaController auditoria;

    public ServicoItemController() {
        dao = new ServicoItemDAO();
        auditoria = new AuditoriaController();
    }

    public void salvar(ServicoItem servicoItem, boolean inserir) {

        try {

            ServicoItem servicoItemDB = dao.obter(servicoItem.getServico(), servicoItem.getTipoServico());
            
            if(servicoItemDB == null){
                if(inserir) {
                    dao.inserir(servicoItem);
                    auditoria.salvarInserir(servicoItem.getTipoServico().getId(), Auditoria.Rotina.SERVICO_ITEM);
                }else{
                    dao.alterar(servicoItem);
                    auditoria.salvarAlterar(servicoItem.getTipoServico().getId(), Auditoria.Rotina.SERVICO_ITEM);
                }
            }else{
                if(inserir) {
                    servicoItem.setQuantidade(servicoItem.getQuantidade().add(servicoItemDB.getQuantidade()));
                }
                dao.alterar(servicoItem);
                auditoria.salvarAlterar(servicoItem.getTipoServico().getId(), Auditoria.Rotina.SERVICO_ITEM);
            }

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, servicoItem);
        }

    }

    public void excluir(ServicoItem servicoItem) {
        try {

            dao.excluir(servicoItem);
            auditoria.salvarDeletar(servicoItem.getTipoServico().getId(), Auditoria.Rotina.SERVICO_ITEM);

        } catch (SQLException ex) {
            ExceptionController.tratar(ex, servicoItem);
        }
    }

    public ServicoItem obter(Servico servico, TipoServico tipoServico) {

        ServicoItem servicoItem = null;
        try {
            servicoItem = dao.obter(servico, tipoServico);
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }
        return servicoItem;
    }
    
    public List<ServicoItem> obter(Servico servico) {

        List<ServicoItem> servicoItem = new LinkedList<>();
        try {
            servicoItem = dao.obter(servico);
        } catch (SQLException ex) {
            ExceptionController.tratar(ex);
        }
        return servicoItem;
    }

}