package es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.repositories.base;

import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.entities.Entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryImpl<T extends Entity<ID>, ID> implements Repository<T, ID> {

    private Map<ID, T> map = new HashMap<>();


    @Override
    public long count() {
        return 0;
    }

    @Override
    public void save(T t) {
        map.put(t.getId(), t);
    }

    @Override
    public Collection<T> findAll() {
        return map.values();
    }
}
