package es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.repositories.generic;

import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.entities.Client;
import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.repositories.base.Repository;

import java.util.UUID;

public interface ClientRepository extends Repository<Client, UUID> {
}
