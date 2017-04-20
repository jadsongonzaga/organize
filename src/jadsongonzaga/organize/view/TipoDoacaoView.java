
package jadsongonzaga.organize.view;

import jadsongonzaga.organize.controller.BuscaTipoDoacaoController;
import jadsongonzaga.organize.controller.TipoDoacaoController;
import jadsongonzaga.organize.model.Acompanhante;
import jadsongonzaga.organize.model.TipoDoacao;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jadson
 */
public class TipoDoacaoView extends javax.swing.JDialog {

    /**
     * Creates new form AcompanhanteView
     * @param parent
     * @param modal
     */
    public TipoDoacaoView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        acao();
        initComponents();
        iniciar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBarraTarefa = new jadsongonzaga.organize.view.PanelBarraTarefa(eventos);
        panelPessoa = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtId = new javax.swing.JTextField();
        jtDescricao = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tipo da doação");
        setResizable(false);

        panelPessoa.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo da doação"));
        panelPessoa.setPreferredSize(new java.awt.Dimension(706, 226));

        jLabel2.setText("Identificador");

        jLabel3.setText("Descrição");

        jtId.setEditable(false);
        jtId.setText("jTextField1");

        jtDescricao.setText("jTextField2");

        javax.swing.GroupLayout panelPessoaLayout = new javax.swing.GroupLayout(panelPessoa);
        panelPessoa.setLayout(panelPessoaLayout);
        panelPessoaLayout.setHorizontalGroup(
            panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPessoaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPessoaLayout.createSequentialGroup()
                        .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 463, Short.MAX_VALUE))
                    .addComponent(jtDescricao))
                .addContainerGap())
        );
        panelPessoaLayout.setVerticalGroup(
            panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPessoaLayout.createSequentialGroup()
                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtDescricao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBarraTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBarraTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TipoDoacaoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>
    

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TipoDoacaoView dialog = new TipoDoacaoView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jtDescricao;
    private javax.swing.JTextField jtId;
    private jadsongonzaga.organize.view.PanelBarraTarefa panelBarraTarefa;
    private javax.swing.JPanel panelPessoa;
    // End of variables declaration//GEN-END:variables

    
    TipoDoacaoController controller = new TipoDoacaoController();
    TipoDoacao tipoDoacao;
    private boolean novo = true;
    Acompanhante acompanhante;

    private void iniciar() {

        modoInicial();
        panelBarraTarefa.getJbConfirmar().setVisible(false);

    }




    private TipoDoacao getTipoDoacao() {
        TipoDoacao tipoC = new TipoDoacao();
        if(!jtId.getText().isEmpty())
            tipoC.setId(Integer.parseInt(jtId.getText()));
        tipoC.setDescricao(jtDescricao.getText());
        
        return tipoC;
    }
    
    private void setTipoDoacao(TipoDoacao tipoDoacao) {
  
        jtId.setText(String.valueOf(tipoDoacao.getId()));
        jtDescricao.setText(tipoDoacao.getDescricao());
    }
    
    private void carregarDados(int id){
        tipoDoacao = controller.obter(id);
        setTipoDoacao(tipoDoacao);
        
    }

    private void evtNovo() {
        UtilsView.limpaComponentes(panelPessoa);
    
        UtilsView.habilitaComponentes(panelPessoa, true);
        jtDescricao.grabFocus();
       
    }
    
    private void modoInicial() {
        UtilsView.limpaComponentes(panelPessoa);
        jtDescricao.grabFocus();
        UtilsView.habilitaComponentes(panelPessoa, false);
        novo = true;
    }
    
    private void modoEditar() {
        
        UtilsView.habilitaComponentes(panelPessoa, true);
        jtDescricao.grabFocus();
    }

    EventosBarraTarefar eventos;

    private void acao() {
        eventos = new EventosBarraTarefar() {
            @Override
            public boolean salvar() {
                List<ComponenteInfo> componentes = new LinkedList<>();
                componentes.add(new ComponenteInfo(jtDescricao, "Descrição"));

                if(UtilsView.validaCamposObrigatorios(componentes)){
                    TipoDoacao tipoDoacao = getTipoDoacao();

                    controller.salvar(tipoDoacao, novo);
                    modoInicial();
                    setTipoDoacao(tipoDoacao);
                    return true;
                }

                return false;
            }

            @Override
            public void novo() {
                evtNovo();
            }

            @Override
            public void cancelar() {
                modoInicial();
            }

            @Override
            public void editar() {
                modoEditar();
                novo = false;
            }

            @Override
            public boolean excluir() {
                int op = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro: "+ tipoDoacao);
                if(op == 0){
                    controller.excluir(tipoDoacao);
                    modoInicial();
                }
                return op == 0;
            }

            @Override
            public void pesquisar() {
                evtPesquisar();
            }

            @Override
            public void confirmar() {

            }
        };
    }
    
    private void evtPesquisar(){
        BuscaTipoDoacaoController busca = new BuscaTipoDoacaoController();
        
        Buscar buscar = new Buscar(null, true, busca.getBuscaController());
        buscar.setVisible(true);
        int id = buscar.getId();
        if(id > 0){
            modoInicial();
            carregarDados(id);
        }
    }
    
    
}
