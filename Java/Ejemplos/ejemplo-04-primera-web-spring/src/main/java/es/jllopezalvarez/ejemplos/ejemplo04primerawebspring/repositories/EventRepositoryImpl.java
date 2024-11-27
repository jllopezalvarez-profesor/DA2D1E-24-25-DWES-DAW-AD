package es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.repositories;

import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.entities.Event;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Repository
public class EventRepositoryImpl implements EventRepository {
    private Map<Long, Event> events = new TreeMap<>();

    @Override
    public long count() {
        return events.size();
    }

    @Override
    public List<Event> findAll() {
        return List.copyOf(events.values());
    }

    @Override
    public Event findById(long id) {
        return events.get(id);
    }

    @Override
    public void save(Event event) {
        events.put(event.getEventId(), event);
    }
}
