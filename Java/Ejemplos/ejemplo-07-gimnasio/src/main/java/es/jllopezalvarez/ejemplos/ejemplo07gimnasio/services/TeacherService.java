package es.jllopezalvarez.ejemplos.ejemplo07gimnasio.services;

import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.entities.Teacher;
import jakarta.transaction.Transactional;

import java.util.List;


public interface TeacherService {
    List<Teacher> findAll();

    List<Teacher> findByInitial(String letra);

    Long countStudentsByTeacherId(Long teacherId);

    Long countStudentsByTeacherIdJpql(Long teacherId);
}
