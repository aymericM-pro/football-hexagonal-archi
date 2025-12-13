package com.app.footballapispring.auth;

import com.app.footballapispring.core.auth.BcryptPasswordHasher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BcryptPasswordHasherTest {

    private BcryptPasswordHasher passwordHasher;

    @BeforeEach
    void setUp() {
        passwordHasher = new BcryptPasswordHasher();
    }

    @Test
    void shouldHashPassword() {
        String clearPassword = "mySecretPassword";

        String hashedPassword = passwordHasher.hash(clearPassword);

        assertNotNull(hashedPassword);
        assertNotEquals(clearPassword, hashedPassword);
        assertTrue(hashedPassword.startsWith("$2"));
    }

    @Test
    void shouldMatchCorrectPassword() {
        String clearPassword = "mySecretPassword";
        String hashedPassword = passwordHasher.hash(clearPassword);

        boolean matches = passwordHasher.match(clearPassword, hashedPassword);

        assertTrue(matches);
    }

    @Test
    void shouldNotMatchIncorrectPassword() {
        String clearPassword = "mySecretPassword";
        String wrongPassword = "wrongPassword";
        String hashedPassword = passwordHasher.hash(clearPassword);

        boolean matches = passwordHasher.match(wrongPassword, hashedPassword);

        assertFalse(matches);
    }

    @Test
    void shouldGenerateDifferentHashesForSamePassword() {
        String clearPassword = "mySecretPassword";

        String hash1 = passwordHasher.hash(clearPassword);
        String hash2 = passwordHasher.hash(clearPassword);

        assertNotEquals(hash1, hash2);
        assertTrue(passwordHasher.match(clearPassword, hash1));
        assertTrue(passwordHasher.match(clearPassword, hash2));
    }
}
