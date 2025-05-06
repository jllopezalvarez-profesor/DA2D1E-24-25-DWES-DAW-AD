package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.services;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.entities.AppUser;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.entities.Task;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.exceptions.FakeErrorException;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.repositories.AppUserRepository;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.repositories.TaskRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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
        // Excepción "de pega" para demostra control de excepciones en el controlador
        if (new Random().nextDouble() < 0.25 ){
            throw new FakeErrorException("Se ha producido un error de pega");
        }
        // Obtener nombre de usuario
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        // Obtener usuario
        AppUser appUser = appUserRepository.findByEmail(userName)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", userName)));
        // Obtener id de usuario
        Long userId = appUser.getUserId();
        return taskRepository.findAllByUserUserId(userId);
    }
}
