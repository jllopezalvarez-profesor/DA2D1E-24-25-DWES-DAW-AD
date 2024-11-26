package es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.repositories.base;

import java.util.HashMap;
import java.util.Map;

public class RepositoryImpl<T, ID> implements Repository<T, ID> {

    private Map<ID, T> data = new HashMap<>();

    @Override
    public T findById(ID id) {
        return data.get(id);
    }
}
