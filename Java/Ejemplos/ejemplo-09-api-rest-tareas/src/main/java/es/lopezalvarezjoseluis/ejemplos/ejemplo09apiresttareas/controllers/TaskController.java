package es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.controllers;

import es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.entities.Task;
import es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/find/{search}/{pageNumber}/{pageSize}")
    public ResponseEntity<List<Task>> findTasks(@PathVariable String search, @PathVariable int pageNumber, @PathVariable int pageSize) {
        return ResponseEntity.ok(taskService.findTasks(search, pageNumber, pageSize) );
    }


}
