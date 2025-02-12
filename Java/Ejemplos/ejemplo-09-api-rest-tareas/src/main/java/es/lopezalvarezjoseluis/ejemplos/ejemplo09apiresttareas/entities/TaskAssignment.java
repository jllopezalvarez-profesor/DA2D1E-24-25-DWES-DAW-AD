package es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
public class TaskAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskAssignmentId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private LocalDateTime assignmentDatetime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private LocalDateTime completionDatetime;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @ManyToOne
    @JoinColumn(name = "task_status_id", nullable = false)
    private TaskStatus taskStatus;

    @ManyToOne
    @JoinColumn(name = "family_member_id", nullable = false)
    private FamilyMember familyMember;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskAssignment that = (TaskAssignment) o;
        return taskAssignmentId == that.taskAssignmentId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(taskAssignmentId);
    }
}
