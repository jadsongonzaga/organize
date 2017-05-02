/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadsongonzaga.organize.view;

import jadsongonzaga.organize.controller.BuscaController;
import jadsongonzaga.organize.controller.Utils;
import jadsongonzaga.organize.model.Busca;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author jadson
 */
public class Buscar extends javax.swing.JDialog {
    
    BuscaController controller;

    /**
     * Creates new form Buscar
     * @param parent
     * @param modal
     * @param controller
     */
    public Buscar(java.awt.Frame parent, boolean modal, BuscaController controller) {
        super(parent, modal);
        initComponents();
        this.controller = controller;
        model = new BuscaTableModel(controller.getDados());
        
        //jtbResultado.setModel(model);
        comboCondicoes();
        comboOrdem();
        buscarCodicao();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbResultado = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jbPesquisar = new javax.swing.JButton();
        jcOrdem = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jcCondicao = new javax.swing.JComboBox<>();
        jtPesquisa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar");

        jtbResultado.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbResultado.getTableHeader().setReorderingAllowed(false);
        jtbResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbResultadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbResultado);

        jbPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jadsongonzaga/organize/view/icones/ic_search_black_18dp_1x.png"))); // NOI18N
        jbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarActionPerformed(evt);
            }
        });

        jcOrdem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Pesquisar por:");

        jcCondicao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtPesquisaKeyPressed(evt);
            }
        });

        jLabel3.setText("Ordenar por:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcCondicao, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbPesquisar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcOrdem)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcCondicao)
                    .addComponent(jtPesquisa)
                    .addComponent(jbPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtbResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbResultadoMouseClicked

        if (evt.getClickCount() == 2) {
            buscar();
            dispose();
        }

    }//GEN-LAST:event_jtbResultadoMouseClicked

    private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarActionPerformed


        buscarCodicao();
        // TODO add your handling code here:
    }//GEN-LAST:event_jbPesquisarActionPerformed

    private void jtPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPesquisaKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            buscarCodicao();
        }
        
    }//GEN-LAST:event_jtPesquisaKeyPressed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Buscar dialog = new Buscar(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JComboBox<String> jcCondicao;
    private javax.swing.JComboBox<String> jcOrdem;
    private javax.swing.JTextField jtPesquisa;
    private javax.swing.JTable jtbResultado;
    // End of variables declaration//GEN-END:variables

    private int id = 0;
    BuscaTableModel model;

    private void buscar() {
        int linha = jtbResultado.getSelectedRow();
        id = Integer.parseInt(jtbResultado.getValueAt(linha, 0).toString());
    }

    /**
     * Retorna o codigo obitido na pesquisa
     *
     * @return
     */
    public int getId() {
        return this.id;
    }

    private void comboCondicoes() {
        jcCondicao.setModel(controller.obterModelComboCondicoes());
    }

    private void comboOrdem() {
        jcOrdem.setModel(controller.obterModelComboOrdens());
    }

    private void buscarCodicao() {
        Busca ordem = (Busca) jcOrdem.getSelectedItem();
        Busca condicao = (Busca) jcCondicao.getSelectedItem();;
        String valor = jtPesquisa.getText();
        
        if(condicao.getTipoDado() == Busca.TipoDado.INTEIRO && !valor.isEmpty()){
            if(!Utils.eNumero(valor)){
                JOptionPane.showMessageDialog(this, "<html>Não foi possível realizar a pesquisa.<br>Você pesquisou por um campo numérico e informou texto</html>");
                return;
            }
        }
        List<Map<String, Object>> dados = controller.getDados(ordem, condicao, valor);
        if(dados.size() > 0)
            model = new BuscaTableModel(dados);
        else
            model = new BuscaTableModel();
        jtbResultado.setModel(model);
    }

}
