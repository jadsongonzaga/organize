package jadsongonzaga.organize.view;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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

    private static String mensagemObrigatoriedade(String nomeComponente) {
        return nomeComponente + " é obrigatorio.";
    }

    public static String validaCamposObrigatorios(List<ComponenteInfo> componentes) {

        for (ComponenteInfo cmp : componentes) {
            Component componente = cmp.getComponente();
            String value = cmp.getNome();
            if (componente instanceof JTextField) {

                if (((JTextField) componente).getText().isEmpty()) {
                    ((JTextField) componente).grabFocus();
                    return mensagemObrigatoriedade(value);
                }

            } else if (componente instanceof JDateChooser) {
                if (((JDateChooser) componente).getDate().toString().isEmpty()) {
                    ((JDateChooser) componente).grabFocus();
                    return mensagemObrigatoriedade(value);
                }
            }
        }
        

        return null;
    }
}
