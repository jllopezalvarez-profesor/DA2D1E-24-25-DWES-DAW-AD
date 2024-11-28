package es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.repositories.notgeneric;

import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.entities.Event;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Repository
public class NotGenericEventRepositoryImpl implements NotGenericEventRepository {
    private Map<Long, Event> events = getDefaultRepository();

    private Map<Long, Event> getDefaultRepository() {
        Map<Long, Event> map = new TreeMap<>();
        map.put(1L, new Event(1L, "Evento 1", "Descripción evento 1", LocalDateTime.now(), LocalDateTime.now().plusDays(2)));
        map.put(2L, new Event(2L, "Evento 2", "Descripción evento 2", LocalDateTime.now(), LocalDateTime.now()));
        map.put(3L, new Event(3L, "Evento 3", "Descripción evento 1", LocalDateTime.now(), LocalDateTime.now()));
        return map;
    }

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
