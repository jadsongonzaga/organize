
package jadsongonzaga.organize.exception;

/**
 *
 * @author jadson
 */
public class CepNaoEncontradoException extends Exception{

    public CepNaoEncontradoException() {
        super("Não foi possível obter informaçãoes a partir desse C.E.P.\n1 - Verifique se digitou corretamente.\n2 - Verifique sua conexão com a internet.");
    }
    
}
