package es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.repositories.base;

public interface Repository<T, ID> {
    T findById(ID id);
}
