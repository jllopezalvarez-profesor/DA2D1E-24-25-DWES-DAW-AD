package es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.repositories;


import es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface StudentRepository extends ListCrudRepository<Student, Long> {
}
