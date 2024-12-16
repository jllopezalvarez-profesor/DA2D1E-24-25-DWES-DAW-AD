package es.jllopezalvarez.accesodatos.ejemplos.ejemplo06biblioteca.repositories;

import es.jllopezalvarez.accesodatos.ejemplos.ejemplo06biblioteca.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
