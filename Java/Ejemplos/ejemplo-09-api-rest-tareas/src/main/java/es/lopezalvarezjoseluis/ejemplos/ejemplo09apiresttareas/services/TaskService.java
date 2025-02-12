package es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.services;

import es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.entities.Task;

import java.util.List;

public interface TaskService {
    List<Task> findTasks(String search, int pageNumber, int pageSize);
}
