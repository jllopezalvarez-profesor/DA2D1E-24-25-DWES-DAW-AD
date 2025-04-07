package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.services;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.entities.AppUser;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.entities.Task;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.repositories.AppUserRepository;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.repositories.TaskRepository;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final AppUserRepository appUserRepository;

    public TaskServiceImpl(TaskRepository taskRepository, AppUserRepository appUserRepository) {
        this.taskRepository = taskRepository;
        this.appUserRepository = appUserRepository;
    }

    @Override
    public List<Task> findAllUserTasks() {
        // Se puede obtener el usuario de dos formas.

        // Solo nombre de usuario. De momento sirve con esto.
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        // El "principal" completo, que tiene más información.
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // Usando el nombre de usuario (email), se puede buscar el id de usuario
        AppUser appUser = appUserRepository.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("No existe el usuario con el email: " + username)
        );

        return taskRepository.findAllByUserUserId(appUser.getUserId());
    }
}
