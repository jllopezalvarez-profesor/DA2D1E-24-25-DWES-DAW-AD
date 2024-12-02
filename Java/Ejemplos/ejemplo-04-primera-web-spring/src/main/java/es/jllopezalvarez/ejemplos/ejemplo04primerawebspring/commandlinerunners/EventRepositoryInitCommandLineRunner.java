package es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.commandlinerunners;

import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.entities.Event;
import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.services.EventService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EventRepositoryInitCommandLineRunner implements CommandLineRunner {


    private final EventService eventService;

    public EventRepositoryInitCommandLineRunner(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public void run(String... args) throws Exception {

        eventService.save(new Event(1L, "Evento 1", "Descripción evento 1", LocalDateTime.now(), LocalDateTime.now().plusDays(2)));
        eventService.save(new Event(2L, "Evento 2", "Descripción evento 2", LocalDateTime.now(), LocalDateTime.now()));
        eventService.save(new Event(3L, "Evento 3", "Descripción evento 1", LocalDateTime.now(), LocalDateTime.now()));
        eventService.save(new Event(4L, "Evento 4", "Descripción evento 4", LocalDateTime.now(), LocalDateTime.now().plusDays(1)));


    }
}
