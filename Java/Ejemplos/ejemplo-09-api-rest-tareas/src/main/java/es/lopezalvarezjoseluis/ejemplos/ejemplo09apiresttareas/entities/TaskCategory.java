package es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
public class TaskCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskCategoryId;

    @Column(nullable = false, length = 30)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskCategory that = (TaskCategory) o;
        return Objects.equals(taskCategoryId, that.taskCategoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(taskCategoryId);
    }
}
