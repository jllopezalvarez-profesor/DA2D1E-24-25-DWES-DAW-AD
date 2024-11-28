package es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.repositories.generic;

import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.entities.Event;
import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.repositories.base.RepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepositoryImpl extends RepositoryImpl<Event, Long> implements EventRepository {
}
