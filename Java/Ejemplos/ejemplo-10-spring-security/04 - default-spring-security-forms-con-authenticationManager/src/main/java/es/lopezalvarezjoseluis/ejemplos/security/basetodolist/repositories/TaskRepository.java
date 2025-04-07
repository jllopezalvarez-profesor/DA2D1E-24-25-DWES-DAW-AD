package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.repositories;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByUserUserId(Long userId);
}
