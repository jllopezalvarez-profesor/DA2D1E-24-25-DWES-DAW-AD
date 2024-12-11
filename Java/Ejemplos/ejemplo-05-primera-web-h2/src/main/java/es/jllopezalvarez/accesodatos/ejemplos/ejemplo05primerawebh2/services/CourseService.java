package es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.services;

import es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.entities.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> findAll();

    Course save(Course module);

    Optional<Course> findById(Long id);
}
