package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.services;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.dto.LoginUserDto;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.dto.RegisterUserDto;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.entities.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserService {
    AppUser register(RegisterUserDto registerUserDto);

    Optional<AppUser> findByEmail(String email);

    AppUser save(AppUser user);

    List<AppUser> findAll();
}
