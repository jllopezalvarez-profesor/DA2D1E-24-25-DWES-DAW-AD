package es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.repositories.base;

import java.util.Collection;

public interface Repository<T, ID> {
    long count();
    void save(T t);
    Collection<T> findAll();

}
