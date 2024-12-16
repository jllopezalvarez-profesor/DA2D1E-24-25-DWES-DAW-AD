package es.jllopezalvarez.accesodatos.ejemplos.ejemplo06biblioteca.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users_profiles")
public class UserProfile {
    @Id
    private UUID userId;
    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false, length = 20)
    private String telephone;

    // Relación 1 - 0..1 entre LibraryUser y UserProfile (tablas users y users_profiles)
    // La columna user_id de users es la clave primaria de la tabla
    // La columna user_id de users_profiles es dos cosas:
    //      - Clave primaria de la tabla
    //      - Clave ajena que referencia la clave primaria de users
    // Esto solo se puede hacer si la propietaria de la relación es UserProfile
    // Se añade "@MapsId" para indicar que hay clave ajena hacia LibraryUser
    // En la consola de H2 no aparece la relación, pero si se intenta insertar
    // en users_profiles con un user_id que no exista en users, informa del error
    // de integridad relacional
     @MapsId
     @OneToOne
     @JoinColumn(name = "user_id")
     private LibraryUser user;
}
