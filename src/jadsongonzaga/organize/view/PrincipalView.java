
package jadsongonzaga.organize.view;

import jadsongonzaga.organize.Organize;
import jadsongonzaga.organize.controller.RelatorioTipoCancerMunicipioController;
import jadsongonzaga.organize.model.Usuario;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jadson
 */
public class PrincipalView extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalView
     */
    public PrincipalView() {
        initComponents();
        validarPerfilUsr();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmAtendimento = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jmFinanceiro = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jmUtilitario = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jmAjuda = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jmAtendimento.setMnemonic('A');
        jmAtendimento.setText("Atendimento");

        jMenuItem2.setText("Acompanhante");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jmAtendimento.add(jMenuItem2);

        jMenuItem3.setText("Clínica");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jmAtendimento.add(jMenuItem3);

        jMenuItem4.setText("Paciente");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jmAtendimento.add(jMenuItem4);

        jMenuItem5.setText("Tipo de câncer");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jmAtendimento.add(jMenuItem5);

        jMenu5.setText("Relatórios e gráficos");

        jMenuItem15.setText("Tipos de câncer - Totais");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem15);

        jMenuItem16.setText("Incidência câncer por município");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem16);

        jmAtendimento.add(jMenu5);

        jMenuBar1.add(jmAtendimento);

        jmFinanceiro.setMnemonic('F');
        jmFinanceiro.setText("Financeiro");

        jMenuItem8.setText("Tipo do serviço");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jmFinanceiro.add(jMenuItem8);

        jMenuItem9.setText("Tipo da doação");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jmFinanceiro.add(jMenuItem9);

        jMenuItem10.setText("Doador");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jmFinanceiro.add(jMenuItem10);

        jMenuItem11.setText("Serviço");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jmFinanceiro.add(jMenuItem11);

        jMenuItem12.setText("Doação");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jmFinanceiro.add(jMenuItem12);

        jMenuItem13.setText("Utilização da doação");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jmFinanceiro.add(jMenuItem13);

        jMenuBar1.add(jmFinanceiro);

        jmUtilitario.setMnemonic('e');
        jmUtilitario.setText("Utilitários");

        jMenuItem7.setText("Usuário");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jmUtilitario.add(jMenuItem7);

        jMenuItem14.setText("Instituição");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jmUtilitario.add(jMenuItem14);

        jMenuItem17.setText("Auditoria");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jmUtilitario.add(jMenuItem17);

        jMenuBar1.add(jmUtilitario);

        jmAjuda.setMnemonic('j');
        jmAjuda.setText("Ajuda");

        jMenuItem6.setText("Sobre");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jmAjuda.add(jMenuItem6);

        jMenuBar1.add(jmAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1109, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 649, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        acompanhante();

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        clinica();

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        paciente();
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

        tipoCancer();
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

        sobre();
        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        
        usuario();
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        
        tipoServico();
        
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed

        tipoDoacao();
        
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed

        doador();
        
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed

        servico();
        
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed

        doacao();
        
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed

        utilizacaoDoacao();
        
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed

        instituicao();
        
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed

        totaisTipoCancer();
        
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed

        tipoCancerPorMunicipio();
        
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed

        auditoria();
        
    }//GEN-LAST:event_jMenuItem17ActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenu jmAjuda;
    private javax.swing.JMenu jmAtendimento;
    private javax.swing.JMenu jmFinanceiro;
    private javax.swing.JMenu jmUtilitario;
    // End of variables declaration//GEN-END:variables

    private void acompanhante() {
        AcompanhanteView acompanhante = new AcompanhanteView(this, false, false);
        acompanhante.setLocationRelativeTo(this);
        acompanhante.setVisible(true);
    }

    private void clinica() {
        ClinicaView clinica = new ClinicaView(this, false);
        clinica.setLocationRelativeTo(this);
        clinica.setVisible(true);
    }

    private void tipoCancer() {
        TipoCancerView tc = new TipoCancerView(this, false);
        tc.setLocationRelativeTo(this);
        tc.setVisible(true);
    }

    private void paciente() {
        PacienteView paciente = new PacienteView(this, false);
        paciente.setLocationRelativeTo(this);
        paciente.setVisible(true);
    }

    private void sobre() {
        Sobre sobre = new Sobre(this, true);
        sobre.setLocationRelativeTo(this);
        sobre.setVisible(true);
    }

    private void usuario() {
        UsuarioView usuario = new UsuarioView(this, false);
        usuario.setLocationRelativeTo(this);
        usuario.setVisible(true);
    }
    
    private void tipoServico() {
        TipoServicoView tipoServico = new TipoServicoView(this, false);
        tipoServico.setLocationRelativeTo(this);
        tipoServico.setVisible(true);
    }
    
    private void tipoDoacao() {
        TipoDoacaoView tipoDoacao = new TipoDoacaoView(this, false);
        tipoDoacao.setLocationRelativeTo(this);
        tipoDoacao.setVisible(true);
    }

    private void doador() {
        DoadorView doador = new DoadorView(this, false);
        doador.setLocationRelativeTo(this);
        doador.setVisible(true);
    }
    
    private void servico(){
        ServicoView servico = new ServicoView(this, false);
        servico.setLocationRelativeTo(this);
        servico.setVisible(true);
    }

    private void doacao() {
        DoacaoView doacao = new DoacaoView(this, false);
        doacao.setLocationRelativeTo(this);
        doacao.setVisible(true);
    }

    private void utilizacaoDoacao() {
        UtilizacaoDoacaoView utilDoac = new UtilizacaoDoacaoView(this, false);
        utilDoac.setLocationRelativeTo(this);
        utilDoac.setVisible(true);
    }

    private void instituicao() {
        InstituicaoView instituicao = new InstituicaoView(this, false);
        instituicao.setLocationRelativeTo(this);
        instituicao.setVisible(true);
    }

    private void totaisTipoCancer() {
        TotalTipoCancerView totais = new TotalTipoCancerView(this, false);
        totais.setLocationRelativeTo(this);
        totais.setVisible(true);
    }

    private void tipoCancerPorMunicipio() {
        RelatorioTipoCancerMunicipioController relCtrl = new RelatorioTipoCancerMunicipioController();
        
        JasperPrint relat = relCtrl.gerar();

        JasperViewer.viewReport(relat, false);
    }

    private void auditoria() {
        AuditoriaView auditoria = new AuditoriaView(this, false);
        auditoria.setLocationRelativeTo(this);
        auditoria.setVisible(true);
    }
    
    private void validarPerfilUsr(){
        if(Organize.USUARIO.getTipo() == Usuario.Tipo.ATENDIMENTO){
            jmFinanceiro.setVisible(false);
            jmUtilitario.setVisible(false);
        }else if(Organize.USUARIO.getTipo() == Usuario.Tipo.FINANCEIRO){
            jmUtilitario.setVisible(false);
        }
    }
}
