package es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.repositories.notgeneric;

import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.entities.Event;

import java.util.List;

public interface NotGenericEventRepository {
    long count();
    List<Event> findAll();
    Event findById(long id);
    void save(Event event);
}
