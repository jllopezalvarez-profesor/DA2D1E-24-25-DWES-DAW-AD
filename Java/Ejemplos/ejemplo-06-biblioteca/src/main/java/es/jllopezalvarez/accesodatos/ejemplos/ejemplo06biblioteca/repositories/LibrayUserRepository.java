package es.jllopezalvarez.accesodatos.ejemplos.ejemplo06biblioteca.repositories;

import es.jllopezalvarez.accesodatos.ejemplos.ejemplo06biblioteca.entities.LibraryUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LibrayUserRepository extends JpaRepository<LibraryUser, UUID> {
}
