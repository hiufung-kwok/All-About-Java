package jep.java11;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.ChaCha20ParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Dummy test for ChaCha20 and poly1305.
 *
 * Ref: https://mkyong.com/java/what-is-new-in-java-11/#jep-309-dynamic-class-file-constants
 */
public class jep329NewCryptoAlgo {

    public static void main(String[] args) throws NoSuchPaddingException,
            NoSuchAlgorithmException, InvalidAlgorithmParameterException,
            InvalidKeyException, IllegalBlockSizeException,
            BadPaddingException {
        byte[] pText = null;
        SecretKey key = null;
        byte[] nonce = null;
        int counter = 0;
        // ChaCha20 for cipher.
        Cipher cipher = Cipher.getInstance("ChaCha20");
        ChaCha20ParameterSpec param = new ChaCha20ParameterSpec(nonce, counter);
        cipher.init(Cipher.ENCRYPT_MODE, key, param);
        byte[] encryptedText = cipher.doFinal(pText);


        // ChaCha20 as AEAD modewith Poly1305 authenticator.
        Cipher cipherNew = Cipher.getInstance("ChaCha20-Poly1305");
        // IV, initialization value with nonce
        IvParameterSpec iv = new IvParameterSpec(nonce);
        cipher.init(cipherNew.ENCRYPT_MODE, key, iv);
        byte[] encryptedTextNew = cipher.doFinal(pText);
    }

}
