
package jadsongonzaga.organize.view;

import jadsongonzaga.organize.controller.BuscaPacienteController;
import jadsongonzaga.organize.controller.BuscaServicoController;
import jadsongonzaga.organize.controller.PacienteController;
import jadsongonzaga.organize.controller.ServicoController;
import jadsongonzaga.organize.controller.ServicoItemController;
import jadsongonzaga.organize.model.Paciente;
import jadsongonzaga.organize.model.Servico;
import jadsongonzaga.organize.model.ServicoItem;
import jadsongonzaga.organize.model.Situacao;
import jadsongonzaga.organize.model.TipoServico;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author jadson
 */
public class ServicoView extends javax.swing.JDialog {

    /**
     * Creates new form AcompanhanteView
     * @param parent
     * @param modal
     */
    public ServicoView(java.awt.Frame parent, boolean modal) {
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
        panelServico = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtId = new javax.swing.JTextField();
        jtDescricao = new javax.swing.JTextField();
        jtPaciente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbItens = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jcSituacao = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Serviço");
        setResizable(false);

        panelServico.setBorder(javax.swing.BorderFactory.createTitledBorder("Serviço"));
        panelServico.setPreferredSize(new java.awt.Dimension(706, 226));

        jLabel2.setText("Identificador");

        jLabel3.setText("Descrição");

        jtId.setEditable(false);
        jtId.setText("jTextField1");

        jtDescricao.setText("jTextField2");

        jtPaciente.setEditable(false);
        jtPaciente.setText("jTextField1");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jadsongonzaga/organize/view/icones/ic_search_black_18dp_1x.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Paciente");

        javax.swing.GroupLayout panelServicoLayout = new javax.swing.GroupLayout(panelServico);
        panelServico.setLayout(panelServicoLayout);
        panelServicoLayout.setHorizontalGroup(
            panelServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelServicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelServicoLayout.createSequentialGroup()
                        .addComponent(jtPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelServicoLayout.setVerticalGroup(
            panelServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelServicoLayout.createSequentialGroup()
                .addGroup(panelServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtDescricao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtbItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbItens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbItensMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbItens);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Situação");

        jcSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcSituacao.setEnabled(false);
        jcSituacao.setFocusable(false);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jadsongonzaga/organize/view/icones/ic_add_black_18dp_1x.png"))); // NOI18N
        jButton2.setText("Adicionar item");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jadsongonzaga/organize/view/icones/ic_delete_forever_black_18dp_1x.png"))); // NOI18N
        jButton5.setText("Excluir item");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jcSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton5)))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jadsongonzaga/organize/view/icones/ic_done_all_black_18dp_1x.png"))); // NOI18N
        jButton3.setText("Fechar");
        jButton3.setToolTipText("Fechar o serviço");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jadsongonzaga/organize/view/icones/ic_clear_black_18dp_1x.png"))); // NOI18N
        jButton4.setText("Cancelar");
        jButton4.setToolTipText("Cancelar o serviço");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBarraTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelServico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBarraTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelServico, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        paciente();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        abrirServicoItem();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtbItensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbItensMouseClicked

        if(evt.getClickCount() == 2){
            alterarItem();
        }
        
    }//GEN-LAST:event_jtbItensMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        fechar();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        cancelar();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        excluirItem();
        
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(ServicoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
    

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ServicoView dialog = new ServicoView(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcSituacao;
    private javax.swing.JTextField jtDescricao;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtPaciente;
    private javax.swing.JTable jtbItens;
    private jadsongonzaga.organize.view.PanelBarraTarefa panelBarraTarefa;
    private javax.swing.JPanel panelServico;
    // End of variables declaration//GEN-END:variables

    
    ServicoController controller = new ServicoController();
    Servico servico;
    private boolean novo = true;
    private Paciente paciente;

    ServicoItensTableModel tableModel = new ServicoItensTableModel(servico);

    private void iniciar() {

        modoInicial();
        panelBarraTarefa.getJbConfirmar().setVisible(false);
        carregaComboSitucao();
        carregarTable(servico);
    }
    
    private void paciente() {
        BuscaPacienteController busca = new BuscaPacienteController();
        Buscar buscar = new Buscar(null, true, busca.getBuscaController());
        buscar.setVisible(true);
        int id = buscar.getId();
        if(id > 0){
            paciente = new PacienteController().obter(id);
            jtPaciente.setText(paciente.toString());
        }
    }
    

    private Servico getServico() {
        Servico serv = new Servico();
        if(!jtId.getText().isEmpty())
            serv.setId(Integer.parseInt(jtId.getText()));
        serv.setDescricao(jtDescricao.getText());
        serv.setPaciente(paciente);
        serv.setSituacao((Situacao)jcSituacao.getSelectedItem());
        
        return serv;
    }
    
    private void setServico(Servico serv) {
  
        jtId.setText(String.valueOf(serv.getId()));
        jtDescricao.setText(serv.getDescricao());
        jtPaciente.setText(serv.getPaciente().toString());
        jcSituacao.setSelectedItem(serv.getSituacao());
        
        carregarTable(serv);
        
    }
    
    private void carregarTable(Servico serv){
        tableModel = new ServicoItensTableModel(serv);
        jtbItens.setModel(tableModel);
        
        jtbItens.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jtbItens.getColumnModel().getColumn(0).setPreferredWidth(10);
        jtbItens.getColumnModel().getColumn(1).setPreferredWidth(300);
        jtbItens.getColumnModel().getColumn(2).setPreferredWidth(200);
    }
    
    private void carregarDados(int id){
        servico = controller.obter(id);
        paciente = servico.getPaciente();
        setServico(servico);
    }
    
    private void carregaComboSitucao(){
        jcSituacao.setModel(controller.obterModelComboSituacao());
    }

    private void evtNovo() {
        UtilsView.limpaComponentes(panelServico);
    
        UtilsView.habilitaComponentes(panelServico, true);
        jtDescricao.grabFocus();
       
    }
    
    private void modoInicial() {
        UtilsView.limpaComponentes(panelServico);
        jtDescricao.grabFocus();
        UtilsView.habilitaComponentes(panelServico, false);
        carregarTable(null);
        novo = true;
    }
    
    private void modoEditar() {
        
        UtilsView.habilitaComponentes(panelServico, true);
        jtDescricao.grabFocus();
    }

    EventosBarraTarefas eventos;

    private void acao() {
        eventos = new EventosBarraTarefas() {
            @Override
            public boolean salvar() {
                List<ComponenteInfo> componentes = new LinkedList<>();
                componentes.add(new ComponenteInfo(jtDescricao, "Descrição"));
                componentes.add(new ComponenteInfo(jtPaciente, "Paciente"));

                if(UtilsView.validaCamposObrigatorios(componentes)){
                    servico = getServico();

                    controller.salvar(servico, novo);
                    UtilsView.habilitaComponentes(panelServico, false);
                    setServico(servico);
                    if(novo)
                        abrirServicoItem();
                    
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
                if(servico.getSituacao() != Situacao.ABERTO){
                    JOptionPane.showMessageDialog(null, "Serviço não pode ser excluido pois está " + servico.getSituacao() +".");
                    return false;
                }else{
                    int op = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro: "+ servico +"?");
                    if(op == 0){
                        controller.excluir(servico);
                        modoInicial();
                        JOptionPane.showMessageDialog(null, "Serviço excluído com sucesso.");
                    }
                    return op == 0;
                }
                
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
        BuscaServicoController busca = new BuscaServicoController();
        
        Buscar buscar = new Buscar(null, true, busca.getBuscaController());
        buscar.setVisible(true);
        int id = buscar.getId();
        if(id > 0){
            modoInicial();
            carregarDados(id);
        }
    }

    private void abrirServicoItem() {
        if(servico == null){
            JOptionPane.showMessageDialog(null, "Inicie um novo serviço para adicionar novos itens.");
        }else if(servico.getSituacao() != Situacao.ABERTO){
            JOptionPane.showMessageDialog(null, "Não é possivel adicionar itens ao serviço pois ele está "+servico.getSituacao() +".");
        }else{
            ServicoItemView srvItm = new ServicoItemView(null, true, servico);
            srvItm.setVisible(true);
            carregarTable(servico);
        }
    }

    private void fechar() {
        
        if(servico == null){
            JOptionPane.showMessageDialog(null, "Fechamento não permitido, não há serviço aberto.");
            return;
        }
        if(servico.getSituacao() != Situacao.ABERTO){
            JOptionPane.showMessageDialog(null, "Fechamento não permitido, serviço não está aberto.");
            return;
        }

        int op = JOptionPane.showConfirmDialog(null, "Deseja realmente fechar esse serviço?");
        if (op == 0) {
            servico.setSituacao(Situacao.FECHADO);
            controller.salvar(servico, false);
            setServico(servico);
            JOptionPane.showMessageDialog(null, "Serviço fechado com sucesso.");
        }
    }

    private void cancelar() {
        if(servico == null){
            JOptionPane.showMessageDialog(null, "Cancelamento não permitido, não há serviço aberto.");
            return;
        }
        
        if(servico.getSituacao() == Situacao.CANCELADO){
            JOptionPane.showMessageDialog(null, "Serviço já está cancelado.");
            return;
        }
        
        int op = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar esse serviço?");
        if (op == 0) {
            servico.setSituacao(Situacao.CANCELADO);
            controller.salvar(servico, false);
            setServico(servico);
            JOptionPane.showMessageDialog(null, "Serviço cancelado com sucesso.");
        }
    }

    private void excluirItem() {
        if(servico == null || servico.getSituacao() != Situacao.ABERTO){
            JOptionPane.showMessageDialog(null, "Exclusão não permitida, não há serviço aberto.");
            return;
        }
        
        int linha = jtbItens.getSelectedRow();
        if(linha < 0){
            JOptionPane.showMessageDialog(null, "Exclusão não permitida, não há item selecionado na grade.");
            jtbItens.grabFocus();
            return; 
        }
        
        TipoServico tipoSer = (TipoServico) jtbItens.getModel().getValueAt(linha, 1);
        
        int op = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esse item?", "Exclusão", JOptionPane.INFORMATION_MESSAGE, JOptionPane.QUESTION_MESSAGE);
        if (op == 0) {
            new ServicoItemController().excluir(new ServicoItem(servico, tipoSer));
            
            carregarTable(servico);
            JOptionPane.showMessageDialog(null, "Item excluído com sucesso.");
        }
        
        
    }

    private void alterarItem() {
        if(servico.getSituacao() != Situacao.ABERTO){
            JOptionPane.showMessageDialog(null, "Alteração não permitida, o serviço está " + servico.getSituacao() + "."); 
        }else{
            TipoServico obj = (TipoServico) jtbItens.getModel().getValueAt(jtbItens.getSelectedRow(), 1);
            new ServicoItemView(null, true, servico, new ServicoItemController().obter(servico, obj)).setVisible(true);
            carregarTable(servico);
        }
    }
    
    
}
