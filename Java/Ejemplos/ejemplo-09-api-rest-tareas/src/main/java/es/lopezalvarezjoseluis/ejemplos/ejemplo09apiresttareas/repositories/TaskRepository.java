package es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.repositories;

import es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.entities.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    public Page<Task> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrderByTitle (String title, String description, Pageable pageable);
}
