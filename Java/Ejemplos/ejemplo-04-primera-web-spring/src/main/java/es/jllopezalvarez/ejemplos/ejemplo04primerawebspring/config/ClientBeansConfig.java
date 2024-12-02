package es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.config;

import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.entities.Client;
import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.repositories.generic.ClientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class ClientBeansConfig {


    private final ClientRepository clientRepository;

    public ClientBeansConfig(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }





}
