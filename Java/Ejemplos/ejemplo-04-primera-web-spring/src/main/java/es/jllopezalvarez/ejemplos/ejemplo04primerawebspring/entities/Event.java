package es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.entities;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Event implements Entity<Long> {
    private final Long eventId;
    private final String title;
    private String description;
    private LocalDateTime start;
    private LocalDateTime end;

    @Override
    public Long getId() {
        return this.eventId;
    }
}


