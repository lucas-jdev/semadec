package br.ifrn.semadec.services.jwt;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.user.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class GeneratorToken {

    @Value("${semadec.jwt.secret}")
    private String secret;

    private final String PREFIX = "Bearer";

    @Value("${semadec.jwt.limit}")
    private long limitTimeout;

    public String execute(User user) {
        Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret),
                SignatureAlgorithm.HS256.getJcaName());

        Instant now = Instant.now();
        String jwtToken = Jwts.builder()
                .claim("name", user.getFullName())
                .claim("username", user.getUsername())
                .claim("academic_email", user.getAcademicEmail())
                .claim("responsibilities", user.getFlags())
                .setSubject(user.getUsername())
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(now.plus(5l, ChronoUnit.MINUTES)))
                .signWith(hmacKey)
                .compact();

        final StringBuilder tokenBuilder = new StringBuilder();
        tokenBuilder.append(PREFIX).append(" ").append(jwtToken);

        return tokenBuilder.toString();
    }
}
