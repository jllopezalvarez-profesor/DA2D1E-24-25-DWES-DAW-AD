package es.jllopezalvarez.ejemplos.ejemplo07gimnasio.services;

import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.entities.SportClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SportClassService {
    Optional<SportClass> findById(long l);

    List<SportClass> findByLetterOrderedByNameDesc(String p);

    List<SportClass> findByLetterOrderedByNameDescOptimized(String searchString);
}
