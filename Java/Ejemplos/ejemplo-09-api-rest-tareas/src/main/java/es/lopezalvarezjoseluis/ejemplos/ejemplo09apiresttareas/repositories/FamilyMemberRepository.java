package es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.repositories;

import es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.entities.FamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Integer> {
}
