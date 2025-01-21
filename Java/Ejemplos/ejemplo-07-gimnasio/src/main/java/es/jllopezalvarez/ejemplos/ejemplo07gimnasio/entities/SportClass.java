package es.jllopezalvarez.ejemplos.ejemplo07gimnasio.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "classes")
public class SportClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;

    @OneToMany(mappedBy = "sportClass", fetch = FetchType.EAGER )
    private List<Teacher> teachers;

    @ManyToMany(mappedBy = "sportClasses")
    List<Member> members;


}

