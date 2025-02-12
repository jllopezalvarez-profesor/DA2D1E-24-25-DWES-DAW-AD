package es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.repositories;

import es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.entities.TaskAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskAssignmentRepository extends JpaRepository<TaskAssignment, Integer> {
}
