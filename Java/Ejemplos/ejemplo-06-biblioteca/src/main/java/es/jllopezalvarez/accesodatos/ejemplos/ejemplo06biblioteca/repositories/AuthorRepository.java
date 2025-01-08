package es.jllopezalvarez.accesodatos.ejemplos.ejemplo06biblioteca.repositories;

import es.jllopezalvarez.accesodatos.ejemplos.ejemplo06biblioteca.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
