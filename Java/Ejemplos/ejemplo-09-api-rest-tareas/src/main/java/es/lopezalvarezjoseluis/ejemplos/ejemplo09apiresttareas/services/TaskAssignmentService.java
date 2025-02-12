package es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.services;

import es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.dto.NewTaskAssignmentDto;

public interface TaskAssignmentService {
    void CreateTaskAssignment(NewTaskAssignmentDto taskAssignmentDto);

    void CompleteTaskAssignment(Integer taskAssignmentId);

    boolean ExistsById(Integer taskAssignmentId);

    boolean IsCompleted(Integer taskAssignmentId);
}
