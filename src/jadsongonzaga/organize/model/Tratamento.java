package jadsongonzaga.organize.model;

import java.time.LocalDate;

/**
 *
 * @author jadson
 */
public class Tratamento {

    private int id;
    private boolean quimioterapio;
    private boolean radioterapio;
    private LocalDate dataDiagnostico;
    private LocalDate dataFimTratamento;
    private TipoFim tipoFim;
    private TipoCancer tipoCancer;
    private Clinica clinica;
    private Paciente paciente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isQuimioterapio() {
        return quimioterapio;
    }

    public void setQuimioterapio(boolean quimioterapio) {
        this.quimioterapio = quimioterapio;
    }

    public boolean isRadioterapio() {
        return radioterapio;
    }

    public void setRadioterapio(boolean radioterapio) {
        this.radioterapio = radioterapio;
    }

    public LocalDate getDataDiagnostico() {
        return dataDiagnostico;
    }

    public void setDataDiagnostico(LocalDate dataDiagnostico) {
        this.dataDiagnostico = dataDiagnostico;
    }

    public LocalDate getDataFimTratamento() {
        return dataFimTratamento;
    }

    public void setDataFimTratamento(LocalDate dataFimTratamento) {
        this.dataFimTratamento = dataFimTratamento;
    }

    public TipoFim getTipoFim() {
        return tipoFim;
    }

    public void setTipoFim(TipoFim tipoFim) {
        this.tipoFim = tipoFim;
    }

    public TipoCancer getTipoCancer() {
        return tipoCancer;
    }

    public void setTipoCancer(TipoCancer tipoCancer) {
        this.tipoCancer = tipoCancer;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public enum TipoFim {
        CURA(1, "Cura"), OBITO(2, "Óbito");
        private final int id;
        private final String descricao;

        public int getId() {
            return id;
        }

        public String getDescricao() {
            return descricao;
        }

        private TipoFim(int id, String descricao) {
            this.id = id;
            this.descricao = descricao;
        }

        public static TipoFim valueOfId(int id) {
            for (TipoFim tipo : TipoFim.values()) {
                if (tipo.getId() == id) {
                    return tipo;
                }
            }

            return null;
        }

        @Override
        public String toString() {
            return this.descricao;
        }
        
        

    }

}
