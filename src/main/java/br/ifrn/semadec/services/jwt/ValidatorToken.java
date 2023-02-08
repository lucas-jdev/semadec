package br.ifrn.semadec.services.jwt;

import java.security.Key;
import java.util.Base64;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class ValidatorToken {

    @Value("${semadec.jwt.secret}")
    private String secret;

    private final String PREFIX = "Bearer";

    public boolean execute(final String token) {
        final String tokenWithoutPrefix;
        tokenWithoutPrefix = _tokenFormatWithoutPrefix(token);

        Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret),
                SignatureAlgorithm.HS256.getJcaName());

        Jws<Claims> jwt = Jwts.parserBuilder()
                .setSigningKey(hmacKey)
                .build()
                .parseClaimsJws(tokenWithoutPrefix);

        return jwt != null;
    }

    private String _tokenFormatWithoutPrefix(final String token) {
        final String tokenWithoutPrefix;
        tokenWithoutPrefix = token.replace(PREFIX, "").trim();
        return tokenWithoutPrefix;
    }
}
