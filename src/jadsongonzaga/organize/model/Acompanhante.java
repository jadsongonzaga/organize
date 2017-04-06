package jadsongonzaga.organize.model;

/**
 *
 * @author jadson
 */
public class Acompanhante {

    private GrauParentesco grauParentesco;
    private Pessoa pessoa;

    public GrauParentesco getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(GrauParentesco grauParentesco) {
        this.grauParentesco = grauParentesco;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public enum GrauParentesco {
        PAI(1, "Pai"), MAE(2, "Mãe"), IRMAO(3, "Irmã(ão)"), CONJUGE(4,"Cônjuge"), AVO(5, "Avô(ó)"), TIO(6, "Tio(a)"), SOBRINHO(7,"Sobrinho(a)"), PRIMO(8,"Primo(a)"), NENHUM(9,"Nenhum");

        private final int codigo;
        private final String nome;

        private GrauParentesco(int codigo, String nome) {
            this.codigo = codigo;
            this.nome = nome;
        }

        public int getCodigo() {
            return codigo;
        }
        
        public static GrauParentesco valueOfCodigo(int codigo) {

            for (final GrauParentesco indicador : GrauParentesco.values()) {
                if (indicador.getCodigo() == codigo) {
                    return indicador;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.nome;
        }
        
        

    }
}
