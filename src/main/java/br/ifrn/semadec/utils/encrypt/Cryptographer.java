package br.ifrn.semadec.utils.encrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Cryptographer {

    private static final BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    private Cryptographer() {
        throw new IllegalStateException("Utility class");
    }

    public static String encrypt(String password) {
        return PASSWORD_ENCODER.encode(password);
    }

    public static boolean matches(String password, String encoded) {
        return PASSWORD_ENCODER.matches(password, encoded);
    }

}
