package es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.entities;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Client implements Entity<UUID> {

    private UUID clientId;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate createdAt;

    @Override
    public UUID getId() {
        return this.clientId;
    }
}
