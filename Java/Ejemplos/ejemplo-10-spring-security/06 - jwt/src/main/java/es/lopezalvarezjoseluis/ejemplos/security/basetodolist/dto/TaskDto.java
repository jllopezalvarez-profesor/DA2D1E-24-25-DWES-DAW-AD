package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.dto;

import lombok.Getter;
import lombok.Setter;


/**
 * DTO (Data Transfer Object) que representa una tarea dentro de la aplicación.
 * <p>
 * Esta clase se utiliza para transferir los datos de una tarea desde y hacia las capas de la aplicación,
 * como el controlador o el servicio, en el contexto de un sistema de gestión de tareas.
 * </p>
 *
 * <p>Los campos de esta clase incluyen:</p>
 * <ul>
 *     <li>{@code taskId}: El identificador único de la tarea.</li>
 *     <li>{@code title}: El título de la tarea.</li>
 *     <li>{@code description}: Una descripción detallada de la tarea.</li>
 *     <li>{@code status}: El estado actual de la tarea, como "pendiente", "en progreso", "completada", etc.</li>
 *     <li>{@code categoryName}: El nombre de la categoría o tipo al que pertenece la tarea.</li>
 * </ul>
 */
@Getter
@Setter
public class TaskDto {
    private Long taskId;
    private String title;
    private String description;
    private String status;
    private String categoryName;
}
