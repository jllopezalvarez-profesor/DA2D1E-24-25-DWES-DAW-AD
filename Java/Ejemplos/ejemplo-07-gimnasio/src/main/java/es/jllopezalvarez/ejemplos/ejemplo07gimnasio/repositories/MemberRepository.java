package es.jllopezalvarez.ejemplos.ejemplo07gimnasio.repositories;

import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "select avg(age) from members where age > :age", nativeQuery = true)
   // @Query(value = "select avg (m.age) from Member m where m.age > :age ")
//    public int getAvgAgeForOlderThan(@Param("age") Integer age);
//    public Integer getAvgAgeForOlderThan(@Param("age") Integer edad);
     public Optional<Double> getAvgAgeForOlderThan(@Param("age") Integer edad);
    // OptionalDouble getAvgAgeForOlderThan(@Param("age") Integer edad);
}
