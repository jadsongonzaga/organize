

package jadsongonzaga.organize;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author jadson
 */
public class Criptografia {
    
    
    private static final Key CHAVE_SECRETA = new SecretKeySpec("Srt976xYzIkmWPAs".getBytes(), "AES");
    
    public static String encode(String texto){
                Cipher cipher;
        byte[] textoEncriptado = null;
        try {
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, CHAVE_SECRETA);
            textoEncriptado = cipher.doFinal(texto.getBytes());

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String strB64 = Base64.getEncoder().encodeToString(textoEncriptado);
        
        return strB64;
    }
    
    
    public static String decode(String texto){
        Cipher cipher;
        String decrypted = null;

        byte [] encrypted = Base64.getDecoder().decode(texto);
        try {
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, CHAVE_SECRETA);

            decrypted = new String(cipher.doFinal(encrypted));
        
        } catch (IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return decrypted;
    }

}
