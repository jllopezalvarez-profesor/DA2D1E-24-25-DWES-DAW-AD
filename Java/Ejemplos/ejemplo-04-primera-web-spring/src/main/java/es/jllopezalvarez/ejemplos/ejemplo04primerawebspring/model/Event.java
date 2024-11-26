package es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Event {
    private final int eventId;
    private final String title;
    private String description;
    private LocalDateTime start;
    private LocalDateTime end;

}


