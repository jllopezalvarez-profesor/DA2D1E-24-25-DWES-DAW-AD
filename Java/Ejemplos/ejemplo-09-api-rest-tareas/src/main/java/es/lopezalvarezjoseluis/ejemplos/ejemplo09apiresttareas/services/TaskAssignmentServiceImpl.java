package es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.services;

import es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.dto.NewTaskAssignmentDto;
import es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.entities.FamilyMember;
import es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.entities.Task;
import es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.entities.TaskAssignment;
import es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.entities.TaskStatus;
import es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.repositories.FamilyMemberRepository;
import es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.repositories.TaskAssignmentRepository;
import es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.repositories.TaskRepository;
import es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.repositories.TaskStatusRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {
    private final TaskRepository taskRepository;
    private final FamilyMemberRepository familyMemberRepository;
    private final TaskStatusRepository taskStatusRepository;
    private final TaskAssignmentRepository taskAssignmentRepository;

    public TaskAssignmentServiceImpl(TaskRepository taskRepository, FamilyMemberRepository familyMemberRepository, TaskStatusRepository taskStatusRepository, TaskAssignmentRepository taskAssignmentRepository) {
        this.taskRepository = taskRepository;
        this.familyMemberRepository = familyMemberRepository;
        this.taskStatusRepository = taskStatusRepository;
        this.taskAssignmentRepository = taskAssignmentRepository;
    }

    @Override
    public void CreateTaskAssignment(NewTaskAssignmentDto taskAssignmentDto) {
        // Buscar la tarea. Si no está, lanzar una excepción
        Optional<Task> taskOptional = taskRepository.findById(taskAssignmentDto.getTaskId());
        if (taskOptional.isEmpty()) {
            throw new EntityNotFoundException(String.format("No exite la tarea con id %d", taskAssignmentDto.getTaskId()));
        }
        // Buscar el miembro de la familia. Si no está lanzar excepción.
        Optional<FamilyMember> familyMemberOptional = familyMemberRepository.findById(taskAssignmentDto.getFamilyMemberId());
        if (familyMemberOptional.isEmpty()) {
            throw new EntityNotFoundException(String.format("No existe el miembro de la familia %d", taskAssignmentDto.getFamilyMemberId()));
        }
        // Buscar el estado para inicializar la asignación. Se puede usar getReferenceById
        TaskStatus taskStatus =  taskStatusRepository.getReferenceById(1);

        // Creamos la asiganción para guardarla
        TaskAssignment newTaskAssignment = new TaskAssignment();

        // Asignamos atributos
        newTaskAssignment.setTask(taskOptional.get());
        newTaskAssignment.setFamilyMember(familyMemberOptional.get());
        newTaskAssignment.setTaskStatus(taskStatus);
        newTaskAssignment.setAssignmentDatetime(LocalDateTime.now());

        // Guardar la nueva asignación
        taskAssignmentRepository.save(newTaskAssignment);
    }

    @Override
    public void CompleteTaskAssignment(Integer taskAssignmentId) {
        // Buscar la asignación. Si no está, lanzar una excepción
        Optional<TaskAssignment> taskAssignmentOptional  = taskAssignmentRepository.findById(taskAssignmentId);
        if (taskAssignmentOptional.isEmpty()) {
            throw new EntityNotFoundException(String.format("No existe la asignación de tarea con id %d", taskAssignmentId));
        }
        // Buscar el estado para cambiar la asignación. Se puede usar getReferenceById
        TaskStatus taskStatus =  taskStatusRepository.getReferenceById(3);

        // Obtenemos el objeto dentro del optional
        TaskAssignment taskAssignment = taskAssignmentOptional.orElseThrow();

        // Modificamos atributos
        taskAssignment.setTaskStatus(taskStatus);
        taskAssignment.setCompletionDatetime(LocalDateTime.now());

        // Guardar la asignación
        taskAssignmentRepository.save(taskAssignment);
    }

    @Override
    public boolean ExistsById(Integer taskAssignmentId) {
        return taskAssignmentRepository.existsById(taskAssignmentId);
    }

    @Override
    public boolean IsCompleted(Integer taskAssignmentId) {
        Optional<TaskAssignment> taskAssignmentOptional  = taskAssignmentRepository.findById(taskAssignmentId);
        if (taskAssignmentOptional.isEmpty()) {
            throw new EntityNotFoundException(String.format("No existe la asignación de tarea con id %d", taskAssignmentId));
        }
        return taskAssignmentOptional.orElseThrow().getCompletionDatetime() != null;
    }
}
