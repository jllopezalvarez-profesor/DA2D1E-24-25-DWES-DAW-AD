package es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.commandlinerunners;

import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.entities.Event;
import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.repositories.generic.EventRepository;
import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.repositories.notgeneric.NotGenericEventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EventRepositoryInitCommandLineRunner implements CommandLineRunner {


    private final EventRepository eventRepository;

    public EventRepositoryInitCommandLineRunner(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        eventRepository.save(new Event(1L, "Evento 1", "Descripción evento 1", LocalDateTime.now(), LocalDateTime.now().plusDays(2)));
        eventRepository.save(new Event(2L, "Evento 2", "Descripción evento 2", LocalDateTime.now(), LocalDateTime.now()));
        eventRepository.save(new Event(3L, "Evento 3", "Descripción evento 1", LocalDateTime.now(), LocalDateTime.now()));


    }
}
