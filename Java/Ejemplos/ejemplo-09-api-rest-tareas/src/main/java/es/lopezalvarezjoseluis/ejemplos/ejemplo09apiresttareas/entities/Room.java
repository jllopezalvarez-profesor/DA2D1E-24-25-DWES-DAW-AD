package es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer roomId;
    @Column(nullable = false, length = 50)
    private String name;
    @ManyToMany(mappedBy = "rooms")
    private Set<Task> tasks;
}
