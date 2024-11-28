package es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.repositories.notgeneric;

import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.entities.Client;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

@Repository
public class NotGenericClientRepositoryImpl implements NotGenericClientRepository {
    private Map<UUID, Client> clients = new TreeMap<> ();



    @Override
    public long count() {
        return clients.size();
    }

    @Override
    public List<Client> findAll() {
        return List.copyOf(clients.values());
    }

    @Override
    public Client findById(long id) {
        return clients.get(id);
    }

    @Override
    public void save(Client event) {
        clients.put(event.getClientId(), event);
    }
}
