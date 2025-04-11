package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.services;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.entities.AppUser;

public interface JwtService {
    String generateAccessToken(AppUser user);

    String generateRefreshToken(AppUser user);

    void validateAccessToken(String token);

    void validateRefreshToken(String token);

    String extractUsername(String token);
}
