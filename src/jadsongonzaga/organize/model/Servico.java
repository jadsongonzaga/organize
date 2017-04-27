
package jadsongonzaga.organize.model;

import java.time.LocalDateTime;


/**
 *
 * @author jadson
 */
public class Servico {

    private int id;
    private String descricao;
    private Paciente paciente;
    private Situacao situacao;
    private LocalDateTime dataHoraCriacao;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }
    
    @Override
    public String toString() {
        return this.descricao;
    }

}
