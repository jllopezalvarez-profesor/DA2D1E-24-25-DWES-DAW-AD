package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.services;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.entities.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAllUserTasks();
}
