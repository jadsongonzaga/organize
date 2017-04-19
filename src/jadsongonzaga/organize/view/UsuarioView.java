
package jadsongonzaga.organize.view;

import jadsongonzaga.organize.controller.BuscaUsuarioController;
import jadsongonzaga.organize.controller.UsuarioController;
import jadsongonzaga.organize.controller.Utils;
import jadsongonzaga.organize.model.Acompanhante;
import jadsongonzaga.organize.model.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author jadson
 */
public class UsuarioView extends javax.swing.JDialog {

    /**
     * Creates new form AcompanhanteView
     * @param parent
     * @param modal
     */
    public UsuarioView(java.awt.Frame parent, boolean modal) {
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
        jtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtLogin = new javax.swing.JTextField();
        jtSenha = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcTipo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jtSenha1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tipo de câncer");
        setResizable(false);

        panelPessoa.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuário"));
        panelPessoa.setPreferredSize(new java.awt.Dimension(706, 226));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Identificador");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nome");

        jtId.setEditable(false);
        jtId.setText("jTextField1");

        jtNome.setText("jTextField2");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Senha");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Tipo");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Login");

        jcTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Confimar senha");

        javax.swing.GroupLayout panelPessoaLayout = new javax.swing.GroupLayout(panelPessoa);
        panelPessoa.setLayout(panelPessoaLayout);
        panelPessoaLayout.setHorizontalGroup(
            panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPessoaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPessoaLayout.createSequentialGroup()
                        .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelPessoaLayout.createSequentialGroup()
                        .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtSenha1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jtNome))
                .addGap(285, 285, 285))
        );
        panelPessoaLayout.setVerticalGroup(
            panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPessoaLayout.createSequentialGroup()
                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtSenha1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBarraTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBarraTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UsuarioView dialog = new UsuarioView(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox<String> jcTipo;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtLogin;
    private javax.swing.JTextField jtNome;
    private javax.swing.JPasswordField jtSenha;
    private javax.swing.JPasswordField jtSenha1;
    private jadsongonzaga.organize.view.PanelBarraTarefa panelBarraTarefa;
    private javax.swing.JPanel panelPessoa;
    // End of variables declaration//GEN-END:variables

    
    UsuarioController controller = new UsuarioController();
    Usuario usuario;
    private boolean novo = true;
    

    private void iniciar() {

        modoInicial();
        carregarComboTipo();

    }


    private void carregarComboTipo(){
        jcTipo.setModel(controller.obterModelComboTipo());
    }


    private Usuario getUsuario() {
        Usuario usr = new Usuario();
        if(!jtId.getText().isEmpty())
            usr.setId(Integer.parseInt(jtId.getText()));
        usr.setNome(jtNome.getText());
        usr.setLogin(jtLogin.getText());
        usr.setSenha(jtSenha.getText());
        usr.setTipo((Usuario.Tipo) jcTipo.getSelectedItem());
        
        return usr;
    }
    
    private void setUsuario(Usuario usuario) {
  
        jtId.setText(String.valueOf(usuario.getId()));
        jtNome.setText(usuario.getNome());
        jtLogin.setText(usuario.getLogin());
        jtSenha.setText(usuario.getSenha());
        jcTipo.setSelectedItem(usuario.getTipo());
    }
    
    private void carregarDados(int id){
        usuario = controller.obter(id);
        setUsuario(usuario);
        
    }

    private void evtNovo() {
        UtilsView.limpaComponentes(panelPessoa);
    
        UtilsView.habilitaComponentes(panelPessoa, true);
        jtNome.grabFocus();
       
    }
    
    private void modoInicial() {
        UtilsView.limpaComponentes(panelPessoa);
        jtNome.grabFocus();
        UtilsView.habilitaComponentes(panelPessoa, false);
        novo = true;
    }
    
    private void modoEditar() {
        
        UtilsView.habilitaComponentes(panelPessoa, true);
        jtNome.grabFocus();
    }

    EventosBarraTarefar eventos;

    private void acao() {
        eventos = new EventosBarraTarefar() {
            @Override
            public boolean salvar() {

                Usuario usuario = getUsuario();
          
                controller.salvar(usuario, novo);
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
            public boolean excluir() {
                int op = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro: "+ usuario);
                if(op == 0){
                    controller.excluir(usuario);
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
        BuscaUsuarioController busca = new BuscaUsuarioController();
        
        Buscar buscar = new Buscar(null, true, busca.getBuscaController());
        buscar.setVisible(true);
        int id = buscar.getId();
        if(id > 0){
            modoInicial();
            carregarDados(id);
        }
    }
    
    
}