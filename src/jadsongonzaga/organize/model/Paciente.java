
package jadsongonzaga.organize.model;

import java.time.LocalDate;

/**
 *
 * @author jadson
 */
public class Paciente {
    
    
    private LocalDate dataNacimento;
    private Escolaridade escolaridade;
    private EstadoCivil estadoCivil;
    private int quatidadeFilho;
    private String conjuge;
    private TipoMoradia tipoMoradia;
    private boolean recebeRenda;
    private String observacao;
    private Pessoa pessoa;
    private Acompanhante acompanhante;
    private Tratamento tratamento;

    public LocalDate getDataNacimento() {
        return dataNacimento;
    }

    public void setDataNacimento(LocalDate dataNacimento) {
        this.dataNacimento = dataNacimento;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getQuatidadeFilho() {
        return quatidadeFilho;
    }

    public void setQuatidadeFilho(int quatidadeFilho) {
        this.quatidadeFilho = quatidadeFilho;
    }

    public String getConjuge() {
        return conjuge;
    }

    public void setConjuge(String conjuge) {
        this.conjuge = conjuge;
    }

    public TipoMoradia getTipoMoradia() {
        return tipoMoradia;
    }

    public void setTipoMoradia(TipoMoradia tipoMoradia) {
        this.tipoMoradia = tipoMoradia;
    }

    public boolean isRecebeRenda() {
        return recebeRenda;
    }

    public void setRecebeRenda(boolean recebeRenda) {
        this.recebeRenda = recebeRenda;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Acompanhante getAcompanhante() {
        return acompanhante;
    }

    public void setAcompanhante(Acompanhante acompanhante) {
        this.acompanhante = acompanhante;
    }

    public Tratamento getTratamento() {
        return tratamento;
    }

    public void setTratamento(Tratamento tratamento) {
        this.tratamento = tratamento;
    }

    @Override
    public String toString() {
        return pessoa.toString();
    }
    
    
    
    public enum Escolaridade{
        FUNDAMENTA(1, "Ensino fundamental"), FUNDAMENTA_INCOMPLETO(2, "Ensino fundamental incompleto"), MEDIO(3, "Ensino médio"),
        MEDIO_INCOMPLETO(4, "Ensino médio incompleto"), SUPERIOR(5, "Ensino superior"), SUPERIOR_INCOMPLETO(6, "Ensino superior incompleto");
        
        private final int id;
        private final String nome;

        public int getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }
                
        private Escolaridade(int id, String nome){
            this.id = id;
            this.nome = nome;
        }
        
        public static Escolaridade valueOfCodigo(int id){
            for(Escolaridade e : Escolaridade.values()){
                if(e.getId() == id)
                    return e;
            }
            return null;
        }

        @Override
        public String toString() {
            return this.nome;
        }
        
        
    }
    
    public enum EstadoCivil{
        SOLTEIRO(1, "Solteiro"), CASADO(2, "Casado"), SEPARADO(3, "Separado"), VIUVO(4, "Viúvo");
        
        private final int id;
        private final String nome;
                
        private EstadoCivil(int id, String nome){
            this.id = id;
            this.nome = nome;
        }
        
        public int getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }
        
        public static EstadoCivil valueOfCodigo(int id){
            for(EstadoCivil e : EstadoCivil.values()){
                if(e.getId() == id)
                    return e;
            }
            return null;
        }
        
        @Override
        public String toString() {
            return this.nome;
        }
        
    }
    
    public enum TipoMoradia{
        PROPIA(1, "Própia"), ALUGADA(2, "Alugada"), CEDIDA(3, "Cedida");
          
        private final int id;
        private final String nome;
                
        private TipoMoradia(int id, String nome){
            this.id = id;
            this.nome = nome;
        }
        
        public int getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }
        
        public static TipoMoradia valueOfCodigo(int id){
            for(TipoMoradia e : TipoMoradia.values()){
                if(e.getId() == id)
                    return e;
            }
            return null;
        }
        
        @Override
        public String toString() {
            return this.nome;
        }
        
    }
}
