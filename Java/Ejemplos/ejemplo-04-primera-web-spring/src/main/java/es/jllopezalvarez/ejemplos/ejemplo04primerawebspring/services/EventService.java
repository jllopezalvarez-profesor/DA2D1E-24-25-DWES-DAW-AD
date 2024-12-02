package es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.services;

import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.entities.Event;

import java.util.Collection;
import java.util.Optional;

public interface EventService {
    long count();
    void save(Event event);
    Collection<Event> findAll();
    Optional<Event> findById(Long id);
}
