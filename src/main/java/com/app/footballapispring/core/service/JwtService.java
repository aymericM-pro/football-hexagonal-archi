package com.app.footballapispring.core.service;

public interface JwtService {

    String generateToken(String email, String role);
    String extractEmail(String token);
    String extractRole(String token);
}
