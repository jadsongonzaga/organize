package jadsongonzaga.organize.view;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jadson
 */
public class UtilsView {

    /**
     * Limpa os componentes Text que compõe o Panel
     *
     * @param panel
     */
    public static void limpaComponentes(JPanel panel) {
        Component[] componentes = panel.getComponents();

        for (Component component : componentes) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            } else if (component instanceof JComboBox) {
                ((JComboBox) component).setSelectedIndex(0);
            } else if (component instanceof JDateChooser) {
                ((JDateChooser) component).setDate(null);
            }
        }
    }

    /**
     * Habilita ou desabilita os componente que compõe o Panel
     *
     * @param panel Container com os componentes
     * @param habilita flag
     */
    public static void habilitaComponentes(JPanel panel, boolean habilita) {
        Component[] componentes = panel.getComponents();

        for (Component component : componentes) {
            if (component instanceof JTextField || component instanceof JComboBox || component instanceof JCheckBox || component instanceof JDateChooser) {
                component.setEnabled(habilita);
            }
        }
    }

    private static void mensagemObrigatoriedade(String nomeComponente) {
        JOptionPane.showMessageDialog(null, nomeComponente + " é obrigatorio.");
    }

    public static boolean validaCamposObrigatorios(List<ComponenteInfo> componentes) {

        for (ComponenteInfo cmp : componentes) {
            Component componente = cmp.getComponente();
            String value = cmp.getNome();
            if (componente instanceof JTextField) {

                if (((JTextField) componente).getText().isEmpty()) {
                    ((JTextField) componente).grabFocus();
                    mensagemObrigatoriedade(value);
                    return false;
                }

            } else if (componente instanceof JDateChooser) {
                if (((JDateChooser) componente).getDate().toString().isEmpty()) {
                    ((JDateChooser) componente).grabFocus();
                    mensagemObrigatoriedade(value);
                    return false;
                }
            } else if (componente instanceof JComboBox) {
                if (((JComboBox) componente).getSelectedItem() == null) {
                    ((JComboBox) componente).grabFocus();
                    mensagemObrigatoriedade(value);
                    return false;
                }
            }
        }
        

        return true;
    }
}
