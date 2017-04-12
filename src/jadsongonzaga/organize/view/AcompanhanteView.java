/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadsongonzaga.organize.view;

import jadsongonzaga.organize.controller.AcompanhanteController;
import jadsongonzaga.organize.controller.BuscaAcompanhanteController;
import jadsongonzaga.organize.controller.ClienteViaCepWS;
import jadsongonzaga.organize.controller.EstadoController;
import jadsongonzaga.organize.controller.MunicipioController;
import jadsongonzaga.organize.controller.Utils;
import jadsongonzaga.organize.exception.CepNaoEncontradoException;
import jadsongonzaga.organize.model.Acompanhante;
import jadsongonzaga.organize.model.Endereco;
import jadsongonzaga.organize.model.Estado;
import jadsongonzaga.organize.model.Municipio;
import jadsongonzaga.organize.model.Pessoa;
import javax.swing.JOptionPane;

/**
 *
 * @author jadson
 */
public class AcompanhanteView extends javax.swing.JDialog {

    /**
     * Creates new form AcompanhanteView
     * @param parent
     * @param modal
     */
    public AcompanhanteView(java.awt.Frame parent, boolean modal) {
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
        panelAcompanhante = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcGrauParentesco = new javax.swing.JComboBox<>();
        panelPessoa = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtId = new javax.swing.JTextField();
        jtNome = new javax.swing.JTextField();
        jtTelefone = new javax.swing.JFormattedTextField();
        jtCelular = new javax.swing.JFormattedTextField();
        jtRg = new javax.swing.JTextField();
        jtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtRg1 = new javax.swing.JTextField();
        panelEndereco = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jtCep = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jtLogradouro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtNumero = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtBairro = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jcEstado = new javax.swing.JComboBox();
        jcMunicipio = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acompanhante");
        setResizable(false);

        panelAcompanhante.setBorder(javax.swing.BorderFactory.createTitledBorder("Acompanhante"));

        jLabel1.setText("Grau de parentesto");

        jcGrauParentesco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelAcompanhanteLayout = new javax.swing.GroupLayout(panelAcompanhante);
        panelAcompanhante.setLayout(panelAcompanhanteLayout);
        panelAcompanhanteLayout.setHorizontalGroup(
            panelAcompanhanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAcompanhanteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcGrauParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAcompanhanteLayout.setVerticalGroup(
            panelAcompanhanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAcompanhanteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAcompanhanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcGrauParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPessoa.setBorder(javax.swing.BorderFactory.createTitledBorder("Pessoa"));
        panelPessoa.setPreferredSize(new java.awt.Dimension(706, 226));

        jLabel2.setText("Identificador");

        jLabel3.setText("Nome");

        jLabel4.setText("Telefone");

        jLabel5.setText("Celular");

        jLabel6.setText("R.G.");

        jLabel7.setText("Email");

        jtId.setEditable(false);
        jtId.setText("jTextField1");

        jtNome.setText("jTextField2");

        try {
            jtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jtEmail.setText("jTextField4");

        jLabel8.setText("Profissão");

        javax.swing.GroupLayout panelPessoaLayout = new javax.swing.GroupLayout(panelPessoa);
        panelPessoa.setLayout(panelPessoaLayout);
        panelPessoaLayout.setHorizontalGroup(
            panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPessoaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelPessoaLayout.createSequentialGroup()
                        .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtRg, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtTelefone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                        .addGap(57, 57, 57)
                        .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtRg1)
                            .addComponent(jtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jtNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jtRg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));
        panelEndereco.setPreferredSize(new java.awt.Dimension(709, 128));

        jLabel9.setText("CEP");

        try {
            jtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtCepFocusLost(evt);
            }
        });

        jLabel10.setText("Logradouro");

        jLabel11.setText("Número");

        jLabel12.setText("Bairro");

        jLabel13.setText("Estado");

        jLabel14.setText("Município");

        jcEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcEstadoActionPerformed(evt);
            }
        });

        jcMunicipio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelEnderecoLayout = new javax.swing.GroupLayout(panelEndereco);
        panelEndereco.setLayout(panelEnderecoLayout);
        panelEnderecoLayout.setHorizontalGroup(
            panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcEstado, 0, 195, Short.MAX_VALUE)
                    .addComponent(jtNumero)
                    .addComponent(jtCep))
                .addGap(18, 18, 18)
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(6, 6, 6)
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtBairro)
                    .addComponent(jtLogradouro)
                    .addComponent(jcMunicipio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelEnderecoLayout.setVerticalGroup(
            panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnderecoLayout.createSequentialGroup()
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEnderecoLayout.createSequentialGroup()
                        .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtCep, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtLogradouro, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtNumero, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtBairro, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcEstado)
                            .addComponent(jcMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelEnderecoLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelAcompanhante, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelEndereco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
                    .addComponent(panelPessoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
                    .addComponent(panelBarraTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBarraTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAcompanhante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtCepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtCepFocusLost

        //pesquisa o endereço apenas se não foi informado, validação para edição
        if (jtLogradouro.getText().isEmpty()) {
            evtBuscaCep();
        }
    }//GEN-LAST:event_jtCepFocusLost

    private void jcEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcEstadoActionPerformed

        carregarMunicipios();
    }//GEN-LAST:event_jcEstadoActionPerformed

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
            java.util.logging.Logger.getLogger(AcompanhanteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AcompanhanteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AcompanhanteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AcompanhanteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AcompanhanteView dialog = new AcompanhanteView(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox jcEstado;
    private javax.swing.JComboBox<String> jcGrauParentesco;
    private javax.swing.JComboBox jcMunicipio;
    private javax.swing.JTextField jtBairro;
    private javax.swing.JFormattedTextField jtCelular;
    private javax.swing.JFormattedTextField jtCep;
    private javax.swing.JTextField jtEmail;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtLogradouro;
    private javax.swing.JTextField jtNome;
    private javax.swing.JTextField jtNumero;
    private javax.swing.JTextField jtRg;
    private javax.swing.JTextField jtRg1;
    private javax.swing.JFormattedTextField jtTelefone;
    private javax.swing.JPanel panelAcompanhante;
    private jadsongonzaga.organize.view.PanelBarraTarefa panelBarraTarefa;
    private javax.swing.JPanel panelEndereco;
    private javax.swing.JPanel panelPessoa;
    // End of variables declaration//GEN-END:variables

    EstadoController controllerEstado = new EstadoController();
    AcompanhanteController controller = new AcompanhanteController();
    Acompanhante acompanhate;
    private boolean novo = true;

    private void iniciar() {

        jcEstado.setModel(controllerEstado.obterModelCombo());
        carregarMunicipios();
        carregarGrauParentesco();
        modoInicial();

    }

    private void carregarMunicipios() {
        Estado obj = (Estado) jcEstado.getSelectedItem();
        jcMunicipio.setModel(new MunicipioController().obterModelCombo(obj));
    }

    private void carregarGrauParentesco() {
        jcGrauParentesco.setModel(controller.obterModelComboParentesco());
    }

    private void evtBuscaCep() {
        ClienteViaCepWS clienteCep;
        try {
            clienteCep = new ClienteViaCepWS(jtCep.getText());
            jtBairro.setText(clienteCep.getBairro());
            jtLogradouro.setText(clienteCep.getLogradouro());
            Estado e = new EstadoController().obter(clienteCep.getUf());
            jcEstado.setSelectedItem(e);
            jcMunicipio.setSelectedItem(new MunicipioController().obter(clienteCep.getIbge()));
        } catch (CepNaoEncontradoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void setEndereco(Endereco endereco) {
        jtBairro.setText(endereco.getBairro());
        jtCep.setText(endereco.getCep());
        jtLogradouro.setText(endereco.getLogradouro());
        jtNumero.setText(endereco.getNumero());
        jcEstado.setSelectedItem(endereco.getMunicipio().getEstado());
        jcMunicipio.setSelectedItem(endereco.getMunicipio());
    }

    public Endereco getEndereco() {
        Endereco endereco = new Endereco();
        endereco.setBairro(jtBairro.getText());
        endereco.setCep(Utils.removeFormatacao(jtCep.getText()));
        endereco.setLogradouro(jtLogradouro.getText());
        endereco.setNumero(jtNumero.getText());
        endereco.setMunicipio((Municipio) jcMunicipio.getSelectedItem());

        return endereco;
    }

    public void setPessoa(Pessoa pessoa) {
        jtCelular.setText(pessoa.getCelular());
        jtRg.setText(pessoa.getRg());
        jtId.setText(String.valueOf(pessoa.getId()));
        jtNome.setText(pessoa.getNome());
        jtEmail.setText(pessoa.getEmail());
        jtTelefone.setText(pessoa.getTelefone());
    }

    public Pessoa getPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setCelular(Utils.removeFormatacao(jtCelular.getText()));
        pessoa.setRg(jtRg.getText());
        if (!jtId.getText().equals("")) {
            pessoa.setId(Integer.parseInt(jtId.getText()));
        }
        pessoa.setNome(jtNome.getText());
        pessoa.setEmail(jtEmail.getText());
        pessoa.setTelefone(Utils.removeFormatacao(jtTelefone.getText()));

        return pessoa;
    }

    private Acompanhante getAcompanhante() {
        Acompanhante acompanhante = new Acompanhante();
        acompanhante.setGrauParentesco((Acompanhante.GrauParentesco) jcGrauParentesco.getSelectedItem());
        return acompanhante;
    }
    
    private Acompanhante setAcompanhante(Acompanhante acompanhante) {
        
        jcGrauParentesco.setSelectedItem(acompanhante.getGrauParentesco());
        return acompanhante;
    }
    
    private void carregarDados(int id){
        acompanhate = controller.obter(id);
        setAcompanhante(acompanhate);
        setPessoa(acompanhate.getPessoa());
        setEndereco(acompanhate.getPessoa().getEndereco());
    }

    private void evtNovo() {
        UtilsView.limpaComponentes(panelPessoa);
        UtilsView.limpaComponentes(panelEndereco);
        UtilsView.limpaComponentes(panelAcompanhante);
        jtNome.grabFocus();
        UtilsView.habilitaComponentes(panelPessoa, true);
        UtilsView.habilitaComponentes(panelEndereco, true);
        UtilsView.habilitaComponentes(panelAcompanhante, true);
    }
    
    private void modoInicial() {
        UtilsView.limpaComponentes(panelPessoa);
        UtilsView.limpaComponentes(panelEndereco);
        UtilsView.limpaComponentes(panelAcompanhante);
        jtNome.grabFocus();
        UtilsView.habilitaComponentes(panelPessoa, false);
        UtilsView.habilitaComponentes(panelEndereco, false);
        UtilsView.habilitaComponentes(panelAcompanhante, false);
        novo = true;
    }
    
    private void modoEditar() {
        
        UtilsView.habilitaComponentes(panelPessoa, true);
        UtilsView.habilitaComponentes(panelEndereco, true);
        UtilsView.habilitaComponentes(panelAcompanhante, true);
        jtNome.grabFocus();
    }

    EventosBarraTarefar eventos;

    private void acao() {
        eventos = new EventosBarraTarefar() {
            @Override
            public boolean salvar() {

                Acompanhante acomp = getAcompanhante();
                Pessoa pessoa = getPessoa();
                    
                pessoa.setEndereco(getEndereco());
                acomp.setPessoa(pessoa);
                if(!novo){
                  acomp.getPessoa().getEndereco().setId(acompanhate.getPessoa().getEndereco().getId());
                }
                controller.salvar(acomp, novo);
                modoInicial();
                return true;
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
            public void excluir() {
                int op = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro de: "+ acompanhate.getPessoa());
                if(op == 0){
                    controller.excluir(acompanhate);
                    modoInicial();
                }
            }

            @Override
            public void pesquisar() {
                evtPesquisar();
            }
        };
    }
    
    private void evtPesquisar(){
        BuscaAcompanhanteController busca = new BuscaAcompanhanteController();
        
        Buscar buscar = new Buscar(null, true, busca.getBuscaController());
        buscar.setVisible(true);
        int id = buscar.getId();
        if(id > 0){
            modoInicial();
            carregarDados(id);
        }
    }
    
}
