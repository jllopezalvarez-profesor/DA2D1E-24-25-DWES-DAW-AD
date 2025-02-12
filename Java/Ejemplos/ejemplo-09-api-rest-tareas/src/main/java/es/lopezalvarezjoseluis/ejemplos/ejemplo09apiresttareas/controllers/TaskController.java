package es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.controllers;

import es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.entities.Task;
import es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public ResponseEntity<List<Task>> findTasks(@RequestParam String search,
                                                @RequestParam(defaultValue = "1") int pageNumber,
                                                @RequestParam(defaultValue = "5") int pageSize) {
        return ResponseEntity.ok(taskService.findTasks(search, pageNumber, pageSize));
    }


}
