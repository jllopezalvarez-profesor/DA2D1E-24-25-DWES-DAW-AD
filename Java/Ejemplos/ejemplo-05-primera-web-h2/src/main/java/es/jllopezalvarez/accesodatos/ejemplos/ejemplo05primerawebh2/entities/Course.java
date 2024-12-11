package es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String name;
    private String description;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private List<Student> students;

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
