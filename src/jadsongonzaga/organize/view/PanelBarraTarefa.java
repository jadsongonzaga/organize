/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadsongonzaga.organize.view;

/**
 *
 * @author jadson
 */
public class PanelBarraTarefa extends javax.swing.JPanel {

    /**
     * Creates new form PanelTarefa
     *
     * @param eventos Evendos da barra de tarefas
     */
    public PanelBarraTarefa(EventosBarraTarefar eventos) {
        initComponents();
        this.eventos = eventos;
        modoInicial();
    }

    public PanelBarraTarefa() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jbNovo = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jToolBar1.setFloatable(false);

        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jadsongonzaga/organize/view/icones/ic_note_add_black_18dp_1x.png"))); // NOI18N
        jbNovo.setMnemonic('N');
        jbNovo.setText("Novo");
        jbNovo.setToolTipText("Novo (Alt + N)");
        jbNovo.setFocusable(false);
        jbNovo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });
        jToolBar1.add(jbNovo);

        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jadsongonzaga/organize/view/icones/ic_edit_black_18dp_1x.png"))); // NOI18N
        jbEditar.setMnemonic('E');
        jbEditar.setText("Editar");
        jbEditar.setToolTipText("Editar (Alt + E)");
        jbEditar.setFocusable(false);
        jbEditar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });
        jToolBar1.add(jbEditar);

        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jadsongonzaga/organize/view/icones/ic_save_black_18dp_1x.png"))); // NOI18N
        jbSalvar.setMnemonic('S');
        jbSalvar.setText("Salvar");
        jbSalvar.setToolTipText("Salvar (Alt + S)");
        jbSalvar.setFocusable(false);
        jbSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(jbSalvar);

        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jadsongonzaga/organize/view/icones/ic_cancel_black_18dp_1x.png"))); // NOI18N
        jbCancelar.setMnemonic('C');
        jbCancelar.setText("Cancelar");
        jbCancelar.setToolTipText("Cancelar (Alt + C)");
        jbCancelar.setFocusable(false);
        jbCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(jbCancelar);

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jadsongonzaga/organize/view/icones/ic_delete_forever_black_18dp_1x.png"))); // NOI18N
        jbExcluir.setMnemonic('x');
        jbExcluir.setText("Excluir");
        jbExcluir.setToolTipText("Excluir (Alt + X)");
        jbExcluir.setFocusable(false);
        jbExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jbExcluir);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jadsongonzaga/organize/view/icones/ic_search_black_18dp_1x.png"))); // NOI18N
        jButton1.setMnemonic('P');
        jButton1.setText("Pesquisar");
        jButton1.setToolTipText("Pesquisar (Alt + P)");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed

        habilitaEdicao();
        eventos.novo();

    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed

        habilitaEdicao();
        eventos.editar();

    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed

        if (eventos.salvar()) {
            modoInicial();
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed

        modoInicial();
        eventos.cancelar();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        eventos.pesquisar();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbSalvar;
    // End of variables declaration//GEN-END:variables

    private EventosBarraTarefar eventos;

    public void setEventos(EventosBarraTarefar eventos) {
        this.eventos = eventos;
    }
    
    

    private void habilitaEdicao() {
        jbSalvar.setEnabled(true);
        jbCancelar.setEnabled(true);

        jbExcluir.setEnabled(false);
        jbNovo.setEnabled(false);
        jbEditar.setEnabled(false);

    }

    public void habilitaTodos() {
        jbSalvar.setEnabled(true);
        jbCancelar.setEnabled(true);

        jbExcluir.setEnabled(true);
        jbNovo.setEnabled(true);
        jbEditar.setEnabled(true);
    }

    public void modoInicial() {
        jbSalvar.setEnabled(false);
        jbCancelar.setEnabled(false);

        jbExcluir.setEnabled(false);
        jbNovo.setEnabled(true);
        jbEditar.setEnabled(false);
    }

    public void modoBuscar() {
        jbSalvar.setEnabled(false);
        jbCancelar.setEnabled(true);

        jbExcluir.setEnabled(false);
        jbNovo.setEnabled(true);
        jbEditar.setEnabled(true);
    }
}
