package es.jllopezalvarez.ejemplos.ejemplo07gimnasio.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 100)
    private String firstName;
    @Column(nullable = false, length = 100)
    private String lastName;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 25)
    private String phone;
    @Column(nullable = false)
    private Integer age;

    @ManyToMany
    @JoinTable(name = "members_classes",
            joinColumns = {@JoinColumn(name = "member_id")},
            inverseJoinColumns = {@JoinColumn(name = "class_id")}
    )
    private List<SportClass> sportClasses;

    @Column(columnDefinition = "timestamp default current_timestamp()", nullable = false )
    private LocalDateTime createdAt;

    @Column(columnDefinition = "timestamp default current_timestamp on update current_timestamp()", nullable = false)
    // Con updatable = false, insertable = false podemos evitar que JPA actualice los valores si se asigna valor en Java
    private LocalDateTime updatedAt;

}
