package br.ifrn.semadec.utils.encrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Cryptographer {
    
    private Cryptographer() {
        throw new IllegalStateException("Utility class");
    }

    public static String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

}
