package es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.repositories;


import es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.entities.Course;
import org.springframework.data.repository.ListCrudRepository;

public interface CourseRepository extends ListCrudRepository<Course, Long> {
}
