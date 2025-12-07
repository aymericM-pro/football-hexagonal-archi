package com.app.footballapispring.core.auth;

import com.app.footballapispring.core.service.JwtService;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class JwtTokenProvider implements JwtService {

    private final SecretKey secretKey;
    private final JwtParser jwtParser;
    private final long validityInMs;

    public JwtTokenProvider(
            @Value("${security.jwt.secret}") String secret,
            @Value("${security.jwt.expiration-ms:3600000}") long validityInMs
    ) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
        this.jwtParser = Jwts.parser().verifyWith(secretKey).build();
        this.validityInMs = validityInMs;
    }

    // -------------------------
    // GENERATE TOKEN
    // -------------------------
    @Override
    public String generateToken(String email, String role) {

        var now = LocalDateTime.now();
        var nowInstant = now.atZone(ZoneId.systemDefault()).toInstant();

        var expiryInstant = nowInstant.plusMillis(validityInMs);

        var claims = Jwts.claims()
                .subject(email)
                .add("role", role)
                .build();

        return Jwts.builder()
                .claims(claims)
                .issuedAt(Date.from(nowInstant))
                .expiration(Date.from(expiryInstant))
                .signWith(secretKey)
                .compact();
    }

    @Override
    public String extractEmail(String token) {
        var body = jwtParser.parseSignedClaims(token).getPayload();
        return body.getSubject();
    }

    @Override
    public String extractRole(String token) {
        var body = jwtParser.parseSignedClaims(token).getPayload();
        return body.get("role", String.class);
    }
}
