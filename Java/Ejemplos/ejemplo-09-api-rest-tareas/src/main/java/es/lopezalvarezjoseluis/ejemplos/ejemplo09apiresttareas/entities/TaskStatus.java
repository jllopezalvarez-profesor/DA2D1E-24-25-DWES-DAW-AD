package es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
public class TaskStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskStatusId;
    @Column(nullable = false, length = 100)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskStatus that = (TaskStatus) o;
        return Objects.equals(taskStatusId, that.taskStatusId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(taskStatusId);
    }
}
