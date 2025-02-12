package es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId;
    @Column(nullable = false, length = 255)
    private String title;
    @Column(nullable = true, length = 4000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "task_category_id", nullable = false)
    private TaskCategory category;

    @ManyToMany
    @JoinTable(name = "task_room",
        joinColumns = {@JoinColumn(name = "task_id")},
        inverseJoinColumns = {@JoinColumn(name = "room_id")}
    )
    private Set<Room> rooms;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(taskId, task.taskId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(taskId);
    }
}
