
package jadsongonzaga.organize.view;

/**
 * Eventos a serem implementados para o funcinamento da barra de tarefa
 * @author jadson
 */
public interface EventosBarraTarefar {
     
    /**
     * Evento de salvar
     */
    public boolean salvar();
    
    /**
     * Evento para abrir novo cadastro
     */
    public void novo();
    
    /**
     * Evento para cancelar trasação
     */
    public void cancelar();
    
    /**
     * Evento para editar cadastro
     */
    public void editar();
    
    /**
     * Evento para excluir cadastro
     * @return 
     */
    public boolean excluir();

    /**
     * Eventos para pesquisar
     */
    public void pesquisar();
    
    /**
     * Eventos para pesquisar
     */
    public void confirmar();
    
}
