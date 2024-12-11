package es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.services;

import es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student save(Student student);
}
