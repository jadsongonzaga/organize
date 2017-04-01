package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Propriedades;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jadson
 */
public class PropriedadesController {

    private static final String CAMINHO = "./etc/database.properties";
    private static final String ENDERECO = "endereco";
    private static final String NOME_BANCO = "nomeBanco";
    private static final String PORTA = "porta";
    private static final String USUARIO = "usuario";
    private static final String SENHA = "senha";

    private static Properties getPropFile() {

        Properties props = new Properties();
        File file = new File(CAMINHO);
        FileInputStream fileStr;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fileStr = new FileInputStream(file);
            props.load(fileStr);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropriedadesController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PropriedadesController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return props;

    }

    public static Propriedades getPropriedades() {
        Propriedades propriedades = new Propriedades();
        Properties props = getPropFile();

        propriedades.setEndereco(props.getProperty(ENDERECO));
        propriedades.setNomeBanco(props.getProperty(NOME_BANCO));
        propriedades.setPorta(props.getProperty(PORTA));
        propriedades.setUsuario(props.getProperty(USUARIO));
        propriedades.setSenha(props.getProperty(SENHA));

        return propriedades;
    }

    public static void setPropriedades(Propriedades propriedades) {

        Properties prop = getPropFile();

        prop.setProperty(PORTA, propriedades.getPorta());
        prop.setProperty(USUARIO, propriedades.getUsuario());
        prop.setProperty(SENHA, propriedades.getSenha());
        prop.setProperty(ENDERECO, propriedades.getEndereco());
        prop.setProperty(NOME_BANCO, propriedades.getNomeBanco());

        try {
            FileOutputStream out = new FileOutputStream(new File(CAMINHO));
            prop.store(out, "Arquivo de configuração do Organize");
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropriedadesController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PropriedadesController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
