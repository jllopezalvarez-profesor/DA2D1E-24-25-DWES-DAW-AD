package es.jllopezalvarez.ejemplos.ejemplo07gimnasio.repositories;

import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface TeacherRepository extends ListCrudRepository<Teacher, Long> {
    List<Teacher> findByFirstNameStartingWithOrLastNameStartingWith (String letter1, String letter2);
    List<Teacher> findBySportClassId (Long id);
    List<Teacher> findByFirstNameOrSportClassIdOrderBySportClassName (String firstName, Long id);

}
