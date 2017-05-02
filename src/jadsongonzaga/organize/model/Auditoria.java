package jadsongonzaga.organize.model;

/**
 *
 * @author jadson
 */
public class Auditoria {

    private int id;
    private Rotina rotina;
    private Usuario usuario;
    private TipoOperacao tipoOperacao;
    private int identificacaoRegistro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rotina getRotina() {
        return rotina;
    }

    public void setRotina(Rotina rotina) {
        this.rotina = rotina;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(TipoOperacao tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public int getIdentificacaoRegistro() {
        return identificacaoRegistro;
    }

    public void setIdentificacaoRegistro(int identificacaoRegistro) {
        this.identificacaoRegistro = identificacaoRegistro;
    }

    /**
     * Enum do tipo de operação <br>
     * * INSERT<br>
     * * DELETE<br>
     * * UPDATE<br>
     */
    public enum TipoOperacao {
        INSERT(0, "Inserção"), DELETE(1, "Remoção"), UPDATE(2, "Alteração");

        private final int codigo;
        private final String descricao;

        private TipoOperacao(int codigo, String descricao) {
            this.codigo = codigo;
            this.descricao = descricao;
        }

        public int getCodigo() {
            return codigo;
        }

        public static TipoOperacao valueOfCodigo(int codigo) {
            for (final TipoOperacao indicador : TipoOperacao.values()) {
                if (indicador.getCodigo() == codigo) {
                    return indicador;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.descricao;
        }
        
    }

    /**
     * Enum da rotinas contidas no sistema
     */
    public enum Rotina {
        ENDERECO(1, "Endereço"), PESSOA(2, "Pessoa"), ACOMPANHANTE(3, "Acompanhate"),
        PACIENTE(4, "Paciente"), CLINICA(5, "Clínica"), TIPO_CANCER(6, "Tipo de câncer"),
        TRATAMENTO(7, "Tratamento"), USUARIO(8, "Usuário"), TIPO_DOACAO(9, "Doação"),
        TIPO_SERVICO(10, "Tipo de serviço"), DOADOR(11, "Doador"), SERVICO(12, "Serviço"),
        SERVICO_ITEM(13, "Item do serviço"), DOACAO(14, "Doação"), 
        UTILIZACAO_DOACAO(14, "Utilização da doação"), INSTITUICAO(15, "Intituição");

        private final int codigo;
        private final String descricao;

        private Rotina(int codigo, String descricao) {
            this.codigo = codigo;
            this.descricao = descricao;
        }

        public int getCodigo() {
            return codigo;
        }

        public static Rotina valueOfCodigo(int codigo) {
            for (final Rotina indicador : Rotina.values()) {
                if (indicador.getCodigo() == codigo) {
                    return indicador;
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
