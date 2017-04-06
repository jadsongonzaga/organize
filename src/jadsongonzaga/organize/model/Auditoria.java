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
        INSERT(0), DELETE(1), UPDATE(2);

        private final int codigo;

        private TipoOperacao(int codigo) {
            this.codigo = codigo;
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
    }

    public enum Rotina {
        ENDERECO(1), PESSOA(2);

        private final int codigo;

        private Rotina(int codigo) {
            this.codigo = codigo;
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

    }

}