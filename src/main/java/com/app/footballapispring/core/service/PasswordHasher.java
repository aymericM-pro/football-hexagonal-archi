package com.app.footballapispring.core.service;

public interface PasswordHasher {
    String hash(String password);
    boolean match(String clearPassword, String hashedPassword);
}