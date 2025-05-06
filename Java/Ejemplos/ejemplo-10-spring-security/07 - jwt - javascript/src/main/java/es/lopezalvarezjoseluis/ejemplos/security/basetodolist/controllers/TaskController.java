package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.controllers;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.dto.TaskDto;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.entities.Task;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.exceptions.FakeErrorException;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.services.TaskService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {


    private final TaskService taskService;
    private final ModelMapper modelMapper;

    public TaskController(TaskService taskService, ModelMapper modelMapper) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }

    // Obtiene las tareas del usuario.
    @GetMapping
    public ResponseEntity<List<TaskDto>> getUserTasks() {
        List<TaskDto> tasks = mapToDto(taskService.findAllUserTasks());
        return ResponseEntity.ok(tasks);
    }

//    @ExceptionHandler(FakeErrorException.class)
//    private ResponseEntity<ProblemDetail> handleFakeErrorException(FakeErrorException fakeErrorException) {
//        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.PAYLOAD_TOO_LARGE, fakeErrorException.getMessage());
//        return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body(problemDetail);
//    }

    private TaskDto mapToDto(Task task) {
        return modelMapper.map(task, TaskDto.class);
    }

    private List<TaskDto> mapToDto(List<Task> entities) {
        Type listType = new TypeToken<List<TaskDto>>() {
        }.getType();
        return modelMapper.map(entities, listType);
    }

}
