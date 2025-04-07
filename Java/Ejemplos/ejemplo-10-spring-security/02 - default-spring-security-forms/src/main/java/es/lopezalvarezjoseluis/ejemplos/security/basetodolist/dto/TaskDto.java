package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.dto;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.entities.AppUser;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.entities.Category;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.entities.TaskStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {
    private Long taskId;
    private String title;
    private String description;
    private String status;
    private String categoryName;
}
