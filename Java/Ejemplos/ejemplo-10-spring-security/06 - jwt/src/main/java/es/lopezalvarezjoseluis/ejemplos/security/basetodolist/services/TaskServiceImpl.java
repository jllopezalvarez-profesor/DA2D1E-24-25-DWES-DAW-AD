package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.services;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.entities.Task;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAllUserTasks() {
        // TODO: Obtener credenciales de usuario del contexto de seguridad.
        // No se puede hacer hasta que esté montada la seguridad y haya un usuario.
        return taskRepository.findAllByUserUserId(1L);
    }
}
