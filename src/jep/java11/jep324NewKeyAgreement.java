package jep.java11;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.NamedParameterSpec;


/**
 * Curve25519 and Curve448 are introduced to replace ECDH.
 *
 * Ref: https://openjdk.org/jeps/324
 * https://en.wikipedia.org/wiki/Curve448
 * https://en.wikipedia.org/wiki/Curve25519
 * https://mkyong.com/java/what-is-new-in-java-11/#jep-309-dynamic-class-file-constants
 *
 */
public class jep324NewKeyAgreement {

    public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("XDH");
        NamedParameterSpec paramSpec = new NamedParameterSpec("X25519");
        kpg.initialize(paramSpec);
        KeyPair kp = kpg.generateKeyPair();

        System.out.println("--- Public Key ---");
        PublicKey publicKey = kp.getPublic();

        System.out.println(publicKey.getAlgorithm());   // XDH
        System.out.println(publicKey.getFormat());      // X.509

        // save this public key
        byte[] pubKey = publicKey.getEncoded();

        System.out.println("---");

        System.out.println("--- Private Key ---");
        PrivateKey privateKey = kp.getPrivate();

        System.out.println(privateKey.getAlgorithm());  // XDH
        System.out.println(privateKey.getFormat());     // PKCS#8

        // save this private key
        byte[] priKey = privateKey.getEncoded();
    }
}
