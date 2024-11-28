package es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.repositories.notgeneric;

import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.entities.Client;

import java.util.List;

public interface NotGenericClientRepository {
    long count();
    List<Client> findAll();
    Client findById(long id);
    void save(Client event);
}
