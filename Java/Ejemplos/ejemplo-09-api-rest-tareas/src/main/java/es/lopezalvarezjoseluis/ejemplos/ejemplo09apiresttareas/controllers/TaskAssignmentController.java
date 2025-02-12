package es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.controllers;

import es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.dto.NewTaskAssignmentDto;
import es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.services.TaskAssignmentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/task-assignments")
public class TaskAssignmentController {

    private final TaskAssignmentService taskAssignmentService;

    public TaskAssignmentController(TaskAssignmentService taskAssignmentService) {
        this.taskAssignmentService = taskAssignmentService;
    }

    @PostMapping
    public ResponseEntity<String> createTaskAssignment(@RequestBody NewTaskAssignmentDto newTaskAssignmentDto) {
        try {
            taskAssignmentService.CreateTaskAssignment(newTaskAssignmentDto);
            return ResponseEntity.created(null).body("Asignación creada");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{taskAssignmentId}/complete")
    public ResponseEntity<String> completeTaskAssignment(@PathVariable("taskAssignmentId") Integer taskAssignmentId) {
//        if (taskAssignmentId % 2 == 0) {
//            throw new EntityNotFoundException("Forzando el error para probar");
//        }
        // Comentado porque dejamos que el servicio se encargue de mirarlo
//        if (!taskAssignmentService.ExistsById(taskAssignmentId)) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("No existe la asignación de tarea con id %d", taskAssignmentId));
//        }
        // Lo movemos al servicio y lo quitamos de aquí
//        if (taskAssignmentService.IsCompleted(taskAssignmentId)) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("La tarea con id %d ya ha sido completada", taskAssignmentId));
//        }
        taskAssignmentService.CompleteTaskAssignment(taskAssignmentId);
        return ResponseEntity.ok("Tarea completada");
    }
}
