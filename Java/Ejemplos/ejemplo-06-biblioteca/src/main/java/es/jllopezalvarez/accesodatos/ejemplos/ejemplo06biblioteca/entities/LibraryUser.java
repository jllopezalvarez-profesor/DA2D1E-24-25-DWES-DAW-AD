package es.jllopezalvarez.accesodatos.ejemplos.ejemplo06biblioteca.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class LibraryUser {
    @Id
    private UUID userId;
    @Column(nullable = false, length = 30)
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Loan> loans;

    // UserProfile es propietaria de la relación
    // En este extremo no cambia nada respecto a una relación ManyToOne
     @OneToOne (mappedBy = "user")
     private UserProfile profile;
}
