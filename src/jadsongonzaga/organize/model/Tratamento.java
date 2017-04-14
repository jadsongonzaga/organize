/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadsongonzaga.organize.model;

/**
 *
 * @author jadson
 */
public class Tratamento {
 
    private int id;
    
    /*
    id                  SERIAL NOT NULL,
    quimioterapio       BOOL DEFAULT false NOT NULL,
    radioterapio        BOOL DEFAULT false NOT NULL,
    data_diagnostico    DATE NOT NULL,
    data_fim_tratamento DATE NULL,
    tipo_finalizacao    INTEGER NULL,
    tipo_cancer_id      INTEGER NULL,
    clinica_id          INTEGER NULL,
    paciente_id         INTEGER NULL,*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
