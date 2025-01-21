package es.jllopezalvarez.ejemplos.ejemplo07gimnasio.repositories;

import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository extends ListCrudRepository<Teacher, Long> {
    List<Teacher> findByFirstNameStartingWithOrLastNameStartingWith (String letter1, String letter2);
    List<Teacher> findBySportClassId (Long id);
    List<Teacher> findByFirstNameOrSportClassIdOrderBySportClassName (String firstName, Long id);

    @Query(value = "select count(1) from teachers t\n" +
           "inner join classes c on t.class_id = c.id\n" +
           "inner join members_classes mc on c.id = mc.class_id\n" +
           "inner join members m on mc.member_id = m.id\n" +
           "where t.id = :id", nativeQuery = true)
    Long countTeacherStudentsByTeacherId(@Param("id") Long teacherId);

    @Query("select count(m) from Member m join m.sportClasses sc join sc.teachers t where t.id = :id")
    Long countTeacherStudentsByTeacherIdJpql(@Param("id") Long teacherId);


}
