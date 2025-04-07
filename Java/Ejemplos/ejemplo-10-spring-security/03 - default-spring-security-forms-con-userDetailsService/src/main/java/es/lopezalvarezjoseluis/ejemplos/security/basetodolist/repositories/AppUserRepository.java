package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.repositories;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
}
