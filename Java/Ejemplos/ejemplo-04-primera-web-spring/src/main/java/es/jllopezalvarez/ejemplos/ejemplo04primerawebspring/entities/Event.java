package es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.entities;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Event {
    private final long eventId;
    private final String title;
    private String description;
    private LocalDateTime start;
    private LocalDateTime end;

}


