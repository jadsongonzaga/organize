/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadsongonzaga.organize.controller;

import jadsongonzaga.organize.model.Propriedades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Connection Factory
 * @author jadson
 */
public class Conexao {

    public Connection conectar() {
        Connection con = null;

        try {
            Class.forName("org.postgresql.Driver");
            Propriedades prop = PropriedadesController.getPropriedades();

            con = DriverManager.getConnection("jdbc:postgresql://" + prop.getEndereco() + ":" + prop.getPorta() + "/" + prop.getNomeBanco(), prop.getUsuario(), prop.getSenha());

        } catch (ClassNotFoundException | SQLException ex) {
            ExceptionController.tratar("Problema ao tentar comunicação com o banco de dados.", ex);
        }

        return con;
    }
}
