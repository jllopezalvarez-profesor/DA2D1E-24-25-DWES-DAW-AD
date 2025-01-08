package es.jllopezalvarez.ejemplos.ejemplo07gimnasio.repositories;

import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.entities.SportClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SportClassRepository extends JpaRepository<SportClass, Long> {
    List<SportClass> findByNameIgnoringCaseOrderByNameDesc(String name);
}
