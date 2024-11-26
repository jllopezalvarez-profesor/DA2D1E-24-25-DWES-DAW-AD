package es.jllopezalvarez.ejemplos.ejemplo01primerawebspring.repositories.base;

public interface Repository<T, ID> {
    T findById(ID id);
}
