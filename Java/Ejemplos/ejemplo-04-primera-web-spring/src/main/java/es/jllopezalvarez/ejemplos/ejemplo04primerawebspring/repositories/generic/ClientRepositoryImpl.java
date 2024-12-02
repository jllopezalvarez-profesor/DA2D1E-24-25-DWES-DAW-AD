package es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.repositories.generic;

import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.entities.Client;
import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.repositories.base.RepositoryImpl;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ClientRepositoryImpl extends RepositoryImpl<Client, UUID> implements ClientRepository {
}
