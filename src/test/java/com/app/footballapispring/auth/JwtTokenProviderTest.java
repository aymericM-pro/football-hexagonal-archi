package com.app.footballapispring.auth;

import com.app.footballapispring.core.auth.JwtTokenProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtTokenProviderTest {

    private JwtTokenProvider jwtTokenProvider;

    private static final String SECRET =
            "my-super-secret-key-my-super-secret-key"; // >= 256 bits
    private static final long EXPIRATION_MS = 60_000; // 1 minute

    @BeforeEach
    void setUp() {
        jwtTokenProvider = new JwtTokenProvider(SECRET, EXPIRATION_MS);
    }

    @Test
    void shouldGenerateToken() {
        String token = jwtTokenProvider.generateToken(
                "user@test.com",
                "ROLE_USER"
        );

        assertNotNull(token);
        assertFalse(token.isBlank());
    }

    @Test
    void shouldExtractEmailFromToken() {
        String email = "user@test.com";

        String token = jwtTokenProvider.generateToken(email, "ROLE_USER");

        String extractedEmail = jwtTokenProvider.extractEmail(token);

        assertEquals(email, extractedEmail);
    }

    @Test
    void shouldExtractRoleFromToken() {
        String role = "ROLE_ADMIN";

        String token = jwtTokenProvider.generateToken("admin@test.com", role);

        String extractedRole = jwtTokenProvider.extractRole(token);

        assertEquals(role, extractedRole);
    }


    @Test
    void shouldFailWithInvalidToken() {
        String invalidToken = "invalid.token.value";

        assertThrows(Exception.class, () ->
                jwtTokenProvider.extractEmail(invalidToken)
        );
    }
}
