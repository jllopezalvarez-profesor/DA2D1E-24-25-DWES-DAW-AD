package es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.repositories;

import es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.entities.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStatusRepository extends JpaRepository<TaskStatus, Integer> {
}
