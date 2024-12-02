package es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.services;

import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.entities.Event;
import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.repositories.generic.EventRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public long count() {
        return eventRepository.count();
    }

    @Override
    public void save(Event event) {
        eventRepository.save(event);
    }

    @Override
    public Collection<Event> findAll() {
        return eventRepository.findAll();

    }

    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }
}
